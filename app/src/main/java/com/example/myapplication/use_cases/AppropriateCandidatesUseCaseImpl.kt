package com.example.myapplication.use_cases

import android.util.Log
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
) : BaseUseCase<List<Person>>(), AppropriateCandidatesUseCase {

    override val request: Observable<List<Person>> = Observable.zip<List<Person>, CandidateParam, List<Person>>(
        personRepo.candidates().toObservable(),
        paramRepo.param().toObservable(),
        BiFunction { candidates, param ->
            Thread.sleep(5000)
            candidates.filter { param.appropriate(it) }
        })
        .doOnNext { Log.d("AppropriateCandidates",it.toString()) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}