package com.example.appsem5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow
import kotlinx.android.synthetic.main.activity_after_notification_psychical_health.*

class PsychicalNotification : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification_psychical_health)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var aktywnoscPsychical = sharedPreferences.getInt("aktywnoscPsychical", 1)
        if (aktywnoscPsychical == 1) {
            notification_Psychical.text = "Pomedytuj przez 5 minut"
            notification_packPsychical.setText("Przechodzimy dalej")

        }
        if (aktywnoscPsychical == 2) {
            notification_Psychical.text = "Posprzątaj swój pokój"
            notification_packPsychical.setText("Przechodzimy dalej")

        }
        if (aktywnoscPsychical == 3) {
            notification_Psychical.text =
                "Przewietrz się"
            notification_packPsychical.setText("Przechodzimy dalej")

        }
        if (aktywnoscPsychical == 4) {
            notification_Psychical.text = "Wyzwanie - jutro używaj telefonu max 30 minut"
            notification_packPsychical.setText("Gratulacje!")

        }
        val notification_packPsychical = findViewById<Button>(R.id.notification_packPsychical)

        notification_packPsychical.setOnClickListener {
            if (aktywnoscPsychical == 1) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscPsychical = 2
                editor.putInt("aktywnoscPsychical", aktywnoscPsychical)
                editor.apply()
                startActivity(Intent(this, PsychicalNotification::class.java))
            }
            if (aktywnoscPsychical == 2) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscPsychical = 3
                editor.putInt("aktywnoscPsychical", aktywnoscPsychical)
                editor.apply()
                startActivity(Intent(this, PsychicalNotification::class.java))
            }
            if (aktywnoscPsychical == 3) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscPsychical = 4
                editor.putInt("aktywnoscPsychical", aktywnoscPsychical)
                editor.apply()
                startActivity(Intent(this, PsychicalNotification::class.java))

            }
            if (aktywnoscPsychical == 4) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                var aktywnoscPsychical = 1
                editor.putInt("aktywnoscPsychical", aktywnoscPsychical)
                editor.apply()
                startActivity(Intent(this, WidokAktywnychPakietow::class.java))
            }
        }
    }
}