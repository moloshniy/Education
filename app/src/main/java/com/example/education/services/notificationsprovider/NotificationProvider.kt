package com.example.education.services.notificationsprovider

import android.app.Service
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.example.education.R

class NotificationProvider(private val context: Context) {
    var b = false
    var icon:Int = 0
    private val notificationActions: NotificationActions by lazy {
        NotificationActions(
            context
        )
    }

    fun sendForegroundNotification() {

        if (icon == R.drawable.avd_cross_to_tick){
            icon = R.drawable.avd_tick_to_cross
        }
        else if ((icon == R.drawable.avd_tick_to_cross)) {
            icon = R.drawable.avd_cross_to_tick
        }
        else icon = R.drawable.avd_cross_to_tick


        val playAction = notificationActions.getPlayAction()
        val stopAction = notificationActions.getStopAction()
        val notification = NotificationCompat.Builder(context, "chanel1")
            .setContentTitle("My mediaPlayer")
            .setContentText("is playin - MUSIC NAME ")
            .setSmallIcon(icon)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.fox))
            .addAction(playAction)
            .addAction(stopAction)
            .setStyle(
                androidx.media.app.NotificationCompat
                    .MediaStyle()
                    .setShowActionsInCompactView(0, 1)
            )
            .build()
        (context as Service).startForeground(1, notification)
        b= true
    }
}