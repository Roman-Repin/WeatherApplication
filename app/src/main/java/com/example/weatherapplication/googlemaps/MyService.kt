package com.example.weatherapplication.googlemaps

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.weatherapplication.R
import com.example.weatherapplication.view.main.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (!remoteMessage.data.isNullOrEmpty()) {
            val title = remoteMessage.data[KEY_TITLE]
            val message = remoteMessage.data[KEY_MESSAGE]
            if (!title.isNullOrEmpty() && !message.isNullOrEmpty()) {
                push(title, message)
            }
        }
    }

    private fun push(title: String, message: String) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationIntent = Intent(applicationContext, MainActivity::class.java)
        
        val contentIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationBuilderHigh = NotificationCompat.Builder(this, CHANNEL_ID_HIGH).apply {
            setSmallIcon(R.drawable.ic_map_pin)
            setContentTitle(title)
            setContentText(message)
            setContentIntent(contentIntent)
            priority = NotificationManager.IMPORTANCE_HIGH
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelNameHigh = "NAME $CHANNEL_ID_HIGH"
            val channelDescriptionHigh = "Description $CHANNEL_ID_HIGH"
            val channelPriorityHigh = NotificationManager.IMPORTANCE_HIGH
            val channelHigh =
                NotificationChannel(CHANNEL_ID_HIGH, channelNameHigh, channelPriorityHigh).apply {
                    description = channelDescriptionHigh
                }
            notificationManager.createNotificationChannel(channelHigh)
        }
        notificationManager.notify(NOTIFICATION_ID_HIGH, notificationBuilderHigh.build())

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    companion object {
        private const val NOTIFICATION_ID_HIGH = 1
        private const val CHANNEL_ID_HIGH = "channel_id_high"
        private const val KEY_TITLE = "myTitle"
        private const val KEY_MESSAGE = "myMessage"
    }
}

