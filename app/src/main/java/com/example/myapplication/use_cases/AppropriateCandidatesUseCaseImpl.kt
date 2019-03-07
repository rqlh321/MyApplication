package com.example.myapplication.use_cases

import android.util.Log
import com.example.myapplication.core.params.CandidateParam
import com.example.myapplication.core.params.ParamRepo
import com.example.myapplication.core.person.Person
import com.example.myapplication.core.person.PersonRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppropriateCandidatesUseCaseImpl @Inject constructor(
    paramRepo: ParamRepo,
    personRepo: PersonRepo
) : AppropriateCandidatesUseCase {

    private val checkForAppropriateCandidates = Single
        .zip<List<Person>, CandidateParam, List<Person>>(
            personRepo.candidates(),
            paramRepo.param(),
            BiFunction { candidates, param -> candidates.filter { param.appropriate(it) } })

//        .cache()
        .doOnSuccess {

            Log.d(
                AppropriateCandidatesUseCaseImpl::class.java.simpleName,
                "doOnSuccess ${Thread.currentThread().name}"
            )
        }
        .doOnSubscribe {
            Log.d(
                AppropriateCandidatesUseCaseImpl::class.java.simpleName,
                "doOnSubscribe ${Thread.currentThread().name}"
            )
        }
        .doOnDispose {
            Log.d(
                AppropriateCandidatesUseCaseImpl::class.java.simpleName,
                "doOnDispose ${Thread.currentThread().name}"
            )
        }
        .subscribeOn(Schedulers.single())
        .observeOn(AndroidSchedulers.mainThread())

    override fun checkForAppropriateCandidates(): Single<List<Person>> =
        checkForAppropriateCandidates

}