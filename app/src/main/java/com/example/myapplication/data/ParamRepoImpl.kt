package com.example.myapplication.data

import com.example.myapplication.core.params.CandidateParam
import com.example.myapplication.core.params.ParamRepo
import io.reactivex.Single
import javax.inject.Inject

class ParamRepoImpl @Inject constructor() : ParamRepo {

    override fun param() = Single.just(CandidateParam())

}