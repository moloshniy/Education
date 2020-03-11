package com.example.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fr = MyFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container,fr).addToBackStack(null).commit()
    }

    fun onClick(view: View) {
        val fr = MyFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container,fr).addToBackStack(null).commit()
    }
}
