package com.example.myapplication.data

import com.example.myapplication.core.person.AnyHuman
import com.example.myapplication.core.person.Person
import com.example.myapplication.core.person.PersonRepo
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PersonRepoImpl @Inject constructor() : PersonRepo {

    override fun candidates(): Single<List<Person>> = Single.just(
        listOf<Person>(
            AnyHuman(),
            AnyHuman(),
            AnyHuman()
        )
    )
}