package com.example.myapplication.use_cases

import com.example.myapplication.core.person.Person
import io.reactivex.Single

interface AppropriateCandidatesUseCase {


    fun checkForAppropriateCandidates(): Single<List<Person>>

}