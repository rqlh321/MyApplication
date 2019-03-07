package com.example.myapplication.presentation.candidates

import com.example.myapplication.core.person.Person

class CandidatesContract {

    interface Presenter {

        fun start()

        fun stop()

        fun select(person: Person)

    }

    interface View {

        fun persons(list: List<Person>)

    }

}