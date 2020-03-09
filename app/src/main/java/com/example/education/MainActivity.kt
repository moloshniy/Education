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

        val dates:Dates = Dates()
       dates.addElement(Date(1))
        dates.addElement(Date(2))
        dates.addElement(Date(3))
        for (d in dates){
                Log.e("qqq",d.int.toString())
        }
        for (d in dates){
            Log.e("qqq",d.int.toString())
        }
        for (d in dates){
            Log.e("qqq",d.int.toString())
        }


    }
}
