package com.example.myapplication.presentation.candidates

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.core.person.AnyHuman
import com.example.myapplication.core.person.Person
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CandidatesActivity : DaggerActivity(), CandidatesContract.View {

    @Inject
    protected lateinit var presenter: CandidatesContract.Presenter

    override fun persons(list: List<Person>) {
        output.text = list.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output.setOnClickListener {
            output.text = ""
            presenter.select(AnyHuman())
        }
        presenter.start()
    }

    override fun onDestroy() {
        if (isFinishing) {
            presenter.stop()
        }
        super.onDestroy()
    }
}
