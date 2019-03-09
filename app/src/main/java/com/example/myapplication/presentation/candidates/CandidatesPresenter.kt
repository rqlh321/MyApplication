package com.example.myapplication.presentation.candidates

import com.example.myapplication.core.person.Person
import com.example.myapplication.use_cases.AppropriateCandidatesUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CandidatesPresenter @Inject constructor(
    private val useCase: AppropriateCandidatesUseCase,
    private val view: CandidatesContract.View
) : CandidatesContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun select(person: Person) {
        disposables.add(
            useCase.execute(true).subscribe(
                { persons ->
                    persons?.let { view.persons(it) }
                }, {
                    it.printStackTrace()
                }
            )
        )
    }

    override fun start() {
        disposables.add(
            useCase.execute().subscribe(
                { persons ->
                    persons?.let { view.persons(it) }
                }, {
                    it.printStackTrace()
                }
            )
        )
    }

    override fun stop() {
        disposables.dispose()
    }

}
