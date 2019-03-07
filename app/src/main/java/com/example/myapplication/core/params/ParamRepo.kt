package com.example.myapplication.core.params

import io.reactivex.Single

interface ParamRepo {
    fun param(): Single<CandidateParam>
}