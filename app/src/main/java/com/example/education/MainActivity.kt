package com.example.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent{
  private val str:String by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
