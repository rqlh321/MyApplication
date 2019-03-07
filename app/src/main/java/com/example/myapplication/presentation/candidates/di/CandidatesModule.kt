package com.example.myapplication.presentation.candidates.di

import com.example.myapplication.presentation.candidates.CandidatesContract
import com.example.myapplication.presentation.candidates.CandidatesPresenter
import com.example.myapplication.presentation.candidates.CandidatesActivity
import dagger.Binds
import dagger.Module

@Module
abstract class CandidatesModule {

    @Binds
    @CandidatesScope
    abstract fun provideCandidatesView(lobbyActivity: CandidatesActivity): CandidatesContract.View

    @Binds
    @CandidatesScope
    abstract fun provideCandidatesPresenter(implementation: CandidatesPresenter): CandidatesContract.Presenter

}