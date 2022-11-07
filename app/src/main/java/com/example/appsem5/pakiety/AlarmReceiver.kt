package com.example.appsem5.pakiety

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.appsem5.BrainNotification
import com.example.appsem5.HealthyHabitsNotification
import com.example.appsem5.PsychicalNotification
import com.example.appsem5.pakiety.widokiPoPowiadomieniach.SportNotifcation
import com.example.appsem5.R


class AlarmReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        lateinit var notification: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create notification channel
            val notificationChannel =
                NotificationChannel("1", "notificationName", NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.description = "notificationDesc"

            //Create notification manager
            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }

        // Create the notification to be shown
        if (intent != null) {
            if (intent.extras?.getString("pakiet").equals("sport")) {
                notification = NotificationCompat.Builder(context!!, "1")
                    .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                    .setContentText(intent?.extras?.getString("contentText1"))
                    .setAutoCancel(true)
                    .setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            1,
                            Intent(context, SportNotifcation::class.java), 0
                        )
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }
        }

        if (intent != null) {
            if (intent.extras?.getString("pakiet").equals("trening mozgu")) {
                notification = NotificationCompat.Builder(context!!, "1")
                    .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                    .setContentText(intent?.extras?.getString("contentText1"))
                    .setAutoCancel(true)
                    .setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            1,
                            Intent(context, BrainNotification::class.java), 0
                        )
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }
        }

        if (intent != null) {
            if (intent.extras?.getString("pakiet").equals("zdrowe nawyki")) {
                notification = NotificationCompat.Builder(context!!, "1")
                    .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                    .setContentText(intent?.extras?.getString("contentText1"))
                    .setAutoCancel(true)
                    .setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            1,
                            Intent(context, HealthyHabitsNotification::class.java), 0
                        )
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }
        }

        if (intent != null) {
            if (intent.extras?.getString("pakiet").equals("zdrowie psychiczne")) {
                notification = NotificationCompat.Builder(context!!, "1")
                    .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                    .setContentText(intent?.extras?.getString("contentText1"))
                    .setAutoCancel(true)
                    .setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            1,
                            Intent(context, PsychicalNotification::class.java), 0
                        )
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }
        }

        // Get the Notification manager service
        val notificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Show a notification
        val id = System.currentTimeMillis() / 1000
        notificationManager.notify(id.toInt(), notification.build())
    }
}
