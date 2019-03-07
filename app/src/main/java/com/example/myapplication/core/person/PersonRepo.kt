package com.example.myapplication.core.person

import io.reactivex.Single

interface PersonRepo {
    fun candidates(): Single<List<Person>>
}