package com.example.myapplication.data

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Repo {
    val service: RestService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create<RestService>(RestService::class.java)

}

data class Post(
    var userId: Int = -1,
    var id: Long = -1,
    var title: String = "",
    var body: String = ""
)

interface RestService {

    @GET("posts")
    fun posts(): Single<List<Post>>

}