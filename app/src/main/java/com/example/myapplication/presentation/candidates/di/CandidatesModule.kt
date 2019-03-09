package com.example.myapplication.presentation.candidates.di

import com.example.myapplication.presentation.candidates.CandidatesActivity
import com.example.myapplication.presentation.candidates.CandidatesContract
import com.example.myapplication.presentation.candidates.CandidatesPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CandidatesModule {

    @Binds
    abstract fun provideCandidatesView(lobbyActivity: CandidatesActivity): CandidatesContract.View

    @Binds
    abstract fun provideCandidatesPresenter(implementation: CandidatesPresenter): CandidatesContract.Presenter

}