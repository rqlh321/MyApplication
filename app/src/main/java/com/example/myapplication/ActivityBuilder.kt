package com.example.myapplication

import com.example.myapplication.presentation.candidates.CandidatesActivity
import com.example.myapplication.presentation.candidates.di.CandidatesModule
import com.example.myapplication.presentation.candidates.di.CandidatesScope

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @CandidatesScope
    @ContributesAndroidInjector(modules = [CandidatesModule::class])
    abstract fun bindCandidatesActivity(): CandidatesActivity

}
