package com.example.myapplication.core.person

data class AnyHuman(
    val male: Boolean = true,
    val age: Int = 25,
    val name: String = "Default",
    val profession: String = "Default",
    override val description: String = "$name $profession"
): Person