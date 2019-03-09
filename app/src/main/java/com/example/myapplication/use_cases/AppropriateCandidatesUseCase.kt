package com.example.myapplication.use_cases

import com.example.myapplication.core.person.Person
import io.reactivex.Observable

interface AppropriateCandidatesUseCase {

    fun execute(reload: Boolean = false): Observable<List<Person>>

}