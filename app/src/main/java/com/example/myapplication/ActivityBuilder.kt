package com.example.myapplication

import com.example.myapplication.presentation.candidates.CandidatesActivity
import com.example.myapplication.presentation.candidates.di.CandidatesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [CandidatesModule::class])
    abstract fun bindCandidatesActivity(): CandidatesActivity

}
