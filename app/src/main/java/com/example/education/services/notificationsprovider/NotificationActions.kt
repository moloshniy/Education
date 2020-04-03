package com.example.education.services.notificationsprovider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.core.app.NotificationCompat
import androidx.core.graphics.drawable.IconCompat
import com.example.education.MediaService
import com.example.education.R

class NotificationActions(private val context: Context) {
    var icon:Int = 0
    init {
    val tickToCross = context.getDrawable(R.drawable.avd_tick_to_cross) as AnimatedVectorDrawable
    val crossToTick = context.getDrawable(R.drawable.avd_cross_to_tick) as AnimatedVectorDrawable
    tickToCross.start()
}
    fun getPlayAction(): NotificationCompat.Action {
        if (icon == R.drawable.avd_cross_to_tick){
            icon = R.drawable.avd_tick_to_cross
        }
        else if ((icon == R.drawable.avd_tick_to_cross)) {
            icon = R.drawable.avd_cross_to_tick
        }
        else icon = R.drawable.avd_cross_to_tick


        val icon = IconCompat.createWithResource(context, icon)
        val intent = Intent(context, MediaService::class.java).apply { action = "PLAY" }
        val pending = PendingIntent.getService(
            context,
            1,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        return NotificationCompat.Action(icon, "Play", pending)
    }

    fun getStopAction(): NotificationCompat.Action {
        val icon = IconCompat.createWithResource(context, R.drawable.ic_pause_black_24dp)
        val intent = Intent(context, MediaService::class.java).apply { action = "PAUSE" }
        val pending = PendingIntent.getService(
            context,
            1,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        return NotificationCompat.Action(icon, "Pause", pending)
    }

}
