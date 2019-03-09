package com.example.myapplication.use_cases

import com.example.myapplication.core.params.CandidateParam
import com.example.myapplication.core.params.ParamRepo
import com.example.myapplication.core.person.Person
import com.example.myapplication.core.person.PersonRepo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import javax.inject.Inject

class AppropriateCandidatesUseCaseImpl @Inject constructor(
    paramRepo: ParamRepo,
    personRepo: PersonRepo
) : AppropriateCandidatesUseCase {

    private val request: Observable<List<Person>> = Observable.zip<List<Person>, CandidateParam, List<Person>>(
        personRepo.candidates().toObservable(),
        paramRepo.param().toObservable(),
        BiFunction { candidates, param ->
            Thread.sleep(5000)
            candidates.filter { param.appropriate(it) }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    private lateinit var subject: AsyncSubject<List<Person>>

    override fun execute(reload: Boolean): Observable<List<Person>> {
        if (!::subject.isInitialized || reload) {
            subject = AsyncSubject.create<List<Person>>()
            request.subscribe(subject)
        }

        return subject
    }
}