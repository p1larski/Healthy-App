package com.example.appsem5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow
import kotlinx.android.synthetic.main.activity_after_notification_brain.*

class BrainNotification : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification_brain)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var aktywnoscBrain = sharedPreferences.getInt( "aktywnoscBrain", 1)
        if (aktywnoscBrain == 1) {
            notification_Brain.text = "Ułóz rebus"
            notification_packBrain.setText("Przechodzimy dalej!")

        }
        if (aktywnoscBrain == 2) {
            notification_Brain.text = "Ułóz wierszyk"
            notification_packBrain.setText("Przechodzimy dalej!")

        }
        if (aktywnoscBrain == 3) {
            notification_Brain.text = "Rozwiąż dowolne działanie matematyczne"
            notification_packBrain.setText("Przechodzimy dalej!")

        }
        if (aktywnoscBrain == 4) {
            notification_Brain.text = "Zagraj w skojarzenia"
            notification_packBrain.setText("Gratulacje!")

        }
        val notification_packBrain = findViewById<Button>(R.id.notification_packBrain)
        notification_packBrain.setOnClickListener {
            if (aktywnoscBrain == 1) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscBrain = 2
                editor.putInt("aktywnoscBrain", aktywnoscBrain)
                editor.apply()
                startActivity(Intent(this, BrainNotification::class.java))
            }
            if (aktywnoscBrain == 2) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscBrain = 3
                editor.putInt("aktywnoscBrain", aktywnoscBrain)
                editor.apply()
                startActivity(Intent(this, BrainNotification::class.java))
            }
            if (aktywnoscBrain == 3) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscBrain = 4
                editor.putInt("aktywnoscBrain", aktywnoscBrain)
                editor.apply()
                startActivity(Intent(this, BrainNotification::class.java))
            }
            if (aktywnoscBrain == 4) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscBrain = 1
                editor.putInt("aktywnoscBrain", aktywnoscBrain)
                editor.apply()
                startActivity(Intent(this, WidokAktywnychPakietow::class.java))
            }
        }
    }
}