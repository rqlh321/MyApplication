package com.example.myapplication.use_cases

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun provideAppropriateCandidatesUseCase(implementation: AppropriateCandidatesUseCaseImpl): AppropriateCandidatesUseCase

}