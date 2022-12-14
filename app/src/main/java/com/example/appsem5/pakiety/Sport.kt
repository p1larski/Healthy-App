package com.example.appsem5.pakiety

import android.app.*
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.R
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow

class Sport : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var notificationManager: NotificationManager
    private var isPackageActive = false


    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sport)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val title: TextView = findViewById(R.id.Package1textView1)
        val description: TextView = findViewById(R.id.Package1textView2)
        val activity1: TextView = findViewById(R.id.Package1textView3)
        val activity2: TextView = findViewById(R.id.Package1textView4)
        val activity3: TextView = findViewById(R.id.Package1textView5)
        val activity4: TextView = findViewById(R.id.Package1textView6)
        val activeButton = findViewById<Button>(R.id.Package1button1)
        val editText1 = findViewById<EditText>(R.id.Package1editText1)
        val editText2 = findViewById<EditText>(R.id.Package1editText2)

        title.setText("Sport")
        description.setText("Ten pakiet pozwoli Ci utrzymac dobra forme")
        activity1.setText("15 minut rozciagania")
        activity2.setText("10 pompek")
        activity3.setText("15 przysiadow")
        activity4.setText("Padnij powstan przez 30 sekund")
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)


        activeButton.setOnClickListener {
            isPackageActive = true
            sharedPreferences.edit().putBoolean("PACK1AC", isPackageActive).apply()
            intent = Intent(this, AlarmReceiver()::class.java)

            // Przygotowanie intent
            intent.putExtra("contentText1", "Zadanie z pakietu \"Sport\"")
            intent.putExtra("pakiet", "sport")

            val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, FLAG_UPDATE_CURRENT)

            //Przygotowanie calendar
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.HOUR_OF_DAY, editText1.text.toString().toInt())
            calendar.set(Calendar.MINUTE, editText2.text.toString().toInt())
            calendar.set(Calendar.SECOND, 0)

            // Przygotowanie alamrManager
            lateinit var alarmManager: AlarmManager
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
            startActivity(Intent(this, WidokAktywnychPakietow::class.java))
        }

        val deactiveButton = findViewById<Button>(R.id.Package1button2)
        deactiveButton.setOnClickListener {
            isPackageActive = false
            sharedPreferences.edit().putBoolean("PACK1AC", isPackageActive).apply()
            startActivity(Intent(this, WidokAktywnychPakietow::class.java))
        }
    }
}