package com.example.education.notification

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.education.R

class MediaServiceExample1 : Service() {
    lateinit var player:MediaPlayer
   val binder:IBinder = Binder()
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("qqq", "OnStartCommand")
        player.start()
        return START_STICKY
    }

    override fun onCreate() {
        Log.e("qqq", "onCreate")
        player = MediaPlayer.create(this, R.raw.my)
        player.isLooping = true


    }



    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
    override fun onDestroy() {

        super.onDestroy()
        Log.e("qqq", "onDestroy")
        player.stop()
    }
}