package com.example.education.notification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.education.MediaService

class ActivityExample1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun onStart(v: View){
        val mediaIntent: Intent = Intent(this, MediaService::class.java)
        startService(mediaIntent)
    }

    fun onStop(v: View){
        val mediaIntent: Intent = Intent(this, MediaService::class.java)
        stopService(mediaIntent)
    }
}
