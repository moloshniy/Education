package com.example.education

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.Delegates


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {

 val myRange = Date(1997,12)..Date(1998,11)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
