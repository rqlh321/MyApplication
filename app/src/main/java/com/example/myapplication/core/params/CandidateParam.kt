package com.example.myapplication.core.params

import com.example.myapplication.core.person.AnyHuman
import com.example.myapplication.core.person.Person

data class CandidateParam(
    val minAge: Int = 23,
    val maxAge: Int = 30
) {
    fun appropriate(person: Person) = if (person is AnyHuman) {
        person.age in minAge..maxAge
    } else {
        false
    }
}
