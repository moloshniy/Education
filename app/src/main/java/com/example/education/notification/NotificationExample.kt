package com.example.education.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import com.example.education.MainActivity
import com.example.education.R

import java.util.*



class NotificationExample {
    @RequiresApi(Build.VERSION_CODES.O)
    fun start(context: Context){
        val intent = Intent(context,MainActivity::class.java)
        val pening = PendingIntent.getActivity(context,1,intent,PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(context, "chanel1")
            .setContentTitle("notificationTitle")
            .setContentText("contentText")
            .setExtras(bundleOf("key" to "value"))
            .setContentIntent(pening)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setColor(context.getColor(R.color.colorPrimary))
            .setUsesChronometer(true)
            .setWhen(Calendar.getInstance().timeInMillis+ 100_000)


            .build()
        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(NotificationChannel("chanel1","chanel1",NotificationManager.IMPORTANCE_HIGH))
        manager.notify(1,notification)

    }
}