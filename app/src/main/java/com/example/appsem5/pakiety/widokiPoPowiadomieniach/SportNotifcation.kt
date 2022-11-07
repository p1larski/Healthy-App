package com.example.appsem5.pakiety.widokiPoPowiadomieniach

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.R
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow
import kotlinx.android.synthetic.main.activity_after_notification_sport.*

class SportNotifcation : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification_sport)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var aktywnosc = sharedPreferences.getInt( "aktywnosc", 1)
        if (aktywnosc == 1) {
            notification_sport.text = "15 minut rozciagania"
            notification_pack1.setText("Przechodzimy dalej!")
        }
        if (aktywnosc == 2) {
            notification_sport.text = "10 pompek"
            notification_pack1.setText("Przechodzimy dalej!")

        }
        if (aktywnosc == 3) {
            notification_sport.text = "15 przysiadow"
            notification_pack1.setText("Przechodzimy dalej!")

        }
        if (aktywnosc == 4) {
            notification_sport.text = "Padnij powstan przez 30 sekund"
            notification_pack1.setText("Gratulacje!")

        }
        val notification_pack1 = findViewById<Button>(R.id.notification_pack1)

        notification_pack1.setOnClickListener {
            if (aktywnosc == 1) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnosc = 2
                editor.putInt("aktywnosc", aktywnosc)
                editor.apply()
                startActivity(Intent(this, SportNotifcation::class.java))
            }
            if (aktywnosc == 2) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnosc = 3
                editor.putInt("aktywnosc", aktywnosc)
                editor.apply()
                startActivity(Intent(this, SportNotifcation::class.java))
            }
            if (aktywnosc == 3) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnosc = 4
                editor.putInt("aktywnosc", aktywnosc)
                editor.apply()
                startActivity(Intent(this, SportNotifcation::class.java))
            }

            if (aktywnosc == 4) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnosc = 1
                editor.putInt("aktywnosc", aktywnosc)
                editor.apply()
                startActivity(Intent(this, WidokAktywnychPakietow::class.java))
            }
        }
    }
}