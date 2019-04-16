package com.example.myapplication.use_cases

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject

abstract class BaseUseCase<T> {

    protected abstract val request: Observable<T>

    private lateinit var subject: AsyncSubject<T>

    fun execute(reload: Boolean): Observable<T> {
        if (!::subject.isInitialized || reload) {
            subject = AsyncSubject.create<T>()
            request.subscribe(subject)
        }

        return subject
    }

}