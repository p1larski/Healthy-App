package com.example.appsem5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow
import kotlinx.android.synthetic.main.activity_after_notification_healthy_habits.*

class HealthyHabitsNotification : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification_healthy_habits)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var aktywnoscHabits = sharedPreferences.getInt( "aktywnoscHabits", 1)
        if (aktywnoscHabits == 1) {
            notification_Habits.text = "Wypij szklankę wody"
            notification_packHabits.setText("Przechodzimy dalej")

        }
        if (aktywnoscHabits == 2) {
            notification_Habits.text = "Zdjedz owoc"
            notification_packHabits.setText("Przechodzimy dalej")

        }
        if (aktywnoscHabits == 3) {
            notification_Habits.text = "Wyzwanie - jutro nie używaj cukru"
            notification_packHabits.setText("Przechodzimy dalej")

        }
        if (aktywnoscHabits == 4) {
            notification_Habits.text = "Wyzwanie - zjedz jutro zdrowe śniadanie"
            notification_packHabits.setText("Gratulacje!")

        }

        val notification_packHabits = findViewById<Button>(R.id.notification_packHabits)
        notification_packHabits.setOnClickListener {
            if (aktywnoscHabits == 1) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscHabits = 2
                editor.putInt("aktywnoscHabits", aktywnoscHabits)
                editor.apply()
                startActivity(Intent(this, HealthyHabitsNotification::class.java))
            }
            if (aktywnoscHabits == 2) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscHabits = 3
                editor.putInt("aktywnoscHabits", aktywnoscHabits)
                editor.apply()
                startActivity(Intent(this, HealthyHabitsNotification::class.java))
            }
            if (aktywnoscHabits == 3) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscHabits = 4
                editor.putInt("aktywnoscHabits", aktywnoscHabits)
                editor.apply()
                startActivity(Intent(this, HealthyHabitsNotification::class.java))

            }
            if (aktywnoscHabits == 4) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscHabits = 1
                editor.putInt("aktywnoscHabits", aktywnoscHabits)
                editor.apply()
                startActivity(Intent(this, WidokAktywnychPakietow::class.java))
            }
        }
    }
}