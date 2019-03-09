package com.example.myapplication

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val lock = CountDownLatch(1)


    @Test
    fun addition_isCorrect() {
        val emitter = Observable.fromArray(1,2,3,4,5)
            .doOnNext { lock.await(1, TimeUnit.SECONDS) }
            .subscribeOn(Schedulers.newThread())

        emitter.subscribe({ println("first: $it") }, {})
        emitter.subscribe({ println("second: $it") }, {})

        lock.await(2, TimeUnit.SECONDS)
    }
}
