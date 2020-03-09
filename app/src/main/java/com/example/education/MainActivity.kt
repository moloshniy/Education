package com.example.education

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import kotlin.properties.Delegates


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Car.CarBuilder().addCarColor("green").build()
        Car2.addWheel(1).addCarColor("2").build()
        val c3:Car3 = Car3.builder {
            this.addAge(11)
            this.addName(11)
        }
    }
}
