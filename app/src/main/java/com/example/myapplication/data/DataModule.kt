package com.example.myapplication.data

import com.example.myapplication.core.params.ParamRepo
import com.example.myapplication.core.person.PersonRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideParamRepo(repo: ParamRepoImpl): ParamRepo

    @Binds
    @Singleton
    abstract fun providePersonRepo(repo: PersonRepoImpl): PersonRepo
}