package com.example.myapplication

import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provide(application: Application): Context

}