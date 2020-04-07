package com.example.education.decorator2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.education.R
import com.example.education.decorator.addToping

class DecoratorActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)
        val qq = Pizza2().addSouce("dsds").addToping("dsds").create()
        Log.e("qqq", "$qq")
    }


}

