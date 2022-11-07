package com.example.appsem5.pakiety

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.appsem5.R
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow

class TreningMozgu : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var notificationManager: NotificationManager
    private var isPackageActive = false


    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.treningmozgu)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val title: TextView = findViewById(R.id.Package2textView1)
        val description: TextView = findViewById(R.id.Package2textView2)
        val activity1: TextView = findViewById(R.id.Package2textView3)
        val activity2: TextView = findViewById(R.id.Package2textView4)
        val activity3: TextView = findViewById(R.id.Package2textView5)
        val activity4: TextView = findViewById(R.id.Package2textView6)
        val activeButton = findViewById<Button>(R.id.Package2button1)
        val editText1 = findViewById<EditText>(R.id.Package2editText1)
        val editText2 = findViewById<EditText>(R.id.Package2editText2)

        title.setText("Trening mozgu")
        description.setText("Ten pakiet pozwoli Ci utrzymac mózg w dobrej kondycji")
        activity1.setText("Ułóz rebus")
        activity2.setText("Ułóz wierszyk")
        activity3.setText("Rozwiąż dowolne zadanie matematyczne")
        activity4.setText("Zagraj w skojarzenia")
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        activeButton.setOnClickListener {
            isPackageActive = true
            sharedPreferences.edit().putBoolean("PACK2AC", isPackageActive).apply()
            intent = Intent(this, AlarmReceiver()::class.java)

            // Przygotowanie intent
            intent.putExtra("contentText1", "Zadanie z pakietu \"Trening mózgu\"")
            intent.putExtra("pakiet", "trening mozgu")

            val pendingIntent = PendingIntent.getBroadcast(this, 2, intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

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

        val deactiveButton = findViewById<Button>(R.id.Package2button2)
        deactiveButton.setOnClickListener {
            isPackageActive = false
            sharedPreferences.edit().putBoolean("PACK2AC", isPackageActive).apply()
            startActivity(Intent(this, WidokAktywnychPakietow::class.java))
        }
    }
}