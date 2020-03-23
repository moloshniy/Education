package com.example.education

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val jobStacker = SupervisorJob_JobAndCancalationHanlder()
            jobStacker.start()

    }
}

