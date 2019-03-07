package com.example.myapplication.presentation.candidates

import android.util.Log
import com.example.myapplication.core.person.Person
import com.example.myapplication.presentation.candidates.di.CandidatesScope
import com.example.myapplication.use_cases.AppropriateCandidatesUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@CandidatesScope
class CandidatesPresenter @Inject constructor(
    private val useCase: AppropriateCandidatesUseCase,
    private val view: CandidatesContract.View
) : CandidatesContract.Presenter {


    private val disposables = CompositeDisposable()

    override fun select(person: Person) {
        Log.d(CandidatesPresenter::class.java.simpleName, person.toString())
    }

    override fun start() {

        disposables.add(
            useCase.checkForAppropriateCandidates()
                .subscribe({ persons ->
                    persons?.let { view.persons(it) }
                }, {
                    it.printStackTrace()
                })

        )

    }

    override fun stop() {
//        disposables.dispose()
    }

}
