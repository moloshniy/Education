package com.example.education

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
     var str:String by MyDelegate().myDelegateInActivityForString()
     var str2:String? by MyDelegate().myDelegateInAnyForAny()
     var myInt:Int by NotEvenDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myInt = 1
        myInt = 2
        myInt = 3

        str = "first"
        str = "second"
        str =  "third"
    }
}
