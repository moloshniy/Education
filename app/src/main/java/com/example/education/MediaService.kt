package com.example.education

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.example.education.services.notificationsprovider.NotificationProvider


class MediaService : Service() {
    private var command = "NONE"
    private val notificationProvider: NotificationProvider by lazy { NotificationProvider(this) }

    override fun onBind(intent: Intent?): IBinder? {
        return Binder()
    }

    override fun onCreate() {
        Log.e("qqq", "onCreate")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        notificationProvider.sendForegroundNotification()
        Log.e("qqq", "OnStartCommand")
        command = intent?.action ?: "NONE"
        when (command) {

            "NONE" -> {
                Log.e("qqq", "NONE WAS SENDED SOMEHOW ???")
            }

            "PLAY" -> Toast.makeText(this, "PLAY", Toast.LENGTH_SHORT).show()
            "STOP" -> Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show()
            "PAUSE" -> Toast.makeText(this, "PAUSE", Toast.LENGTH_SHORT).show()
            "RESTART" -> Toast.makeText(this, "RESTART", Toast.LENGTH_SHORT).show()
        }

        return START_STICKY
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("qqq", "onDestroy")
    }
}