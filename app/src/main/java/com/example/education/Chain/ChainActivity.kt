package com.example.education.Chain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.education.R

class ChainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chain)

        val lenthFilter = LengthFilter()
        val numberFilter = NumberFilter()

        WriteItDown().write(10){
           arrayOf(lenthFilter,numberFilter)
        }

    }
}
