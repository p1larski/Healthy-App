package com.example.appsem5.pakiety.aktywnePakiety

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.appsem5.R
import com.example.appsem5.pakiety.wszystkiePakiety.WidokWszystkichPakietow
import kotlinx.android.synthetic.main.your_packages.*

open class WidokAktywnychPakietow : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.your_packages)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
         preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val sportActivationButton = preferences.getBoolean("PACK1AC", false)
        if (sportActivationButton == true)
            pakiet1ac.text = "Pakiet Sport jest aktywny"

        val treningMozguActivationButton = preferences.getBoolean("PACK2AC", false)
        if (treningMozguActivationButton == true)
            pakiet2ac.text = "Pakiet Trening Mózgu jest aktywny"

        val zdrowieNawykiZywienioweActivationButton = preferences.getBoolean("PACK3AC", false)
        if (zdrowieNawykiZywienioweActivationButton == true)
            pakiet3ac.text = "Pakiet Zdrowe Nawyki Żywieniowe jest aktywny"

        val zdrowiePsychiczneActivationButton = preferences.getBoolean("PACK4AC", false)
        if (zdrowiePsychiczneActivationButton == true)
            pakiet4ac.text = "Pakiet Zdrowie Psychiczne jest aktywny"


        val Your_packagesbutton1 = findViewById<Button>(R.id.Your_packagesbutton1)
        Your_packagesbutton1.setOnClickListener {
            startActivity(Intent(this, WidokWszystkichPakietow::class.java))
        }

    }
}


