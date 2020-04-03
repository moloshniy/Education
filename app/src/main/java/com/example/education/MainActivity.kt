package com.example.education

import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.annotation.RequiresApi
import com.example.education.notification.NotificationExample


class MainActivity : AppCompatActivity() {
    val mediaIntent1:Intent by lazy { Intent(this, MediaService::class.java)}

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // NotificationExample().start(this)

    }

    fun onStart(v: View){
        val mediaIntent:Intent  = Intent(this, MediaService::class.java)
        startService(mediaIntent)
       // startForegroundService(mediaIntent)
    }

    fun onStop(v: View){
        val mediaIntent:Intent  = Intent(this, MediaService::class.java)
        stopService(mediaIntent)
    }

}
