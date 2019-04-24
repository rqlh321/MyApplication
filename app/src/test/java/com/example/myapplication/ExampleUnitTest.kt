package com.example.myapplication

import org.junit.Test

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        testReified("qwe")
        "qwe".javaClass.simpleName
    }

    private inline fun <reified T> testReified(data: T) {
        println(T::class.java.simpleName)
    }

}
