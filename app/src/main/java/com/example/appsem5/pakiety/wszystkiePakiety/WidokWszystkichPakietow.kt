package com.example.appsem5.pakiety.wszystkiePakiety

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.example.appsem5.R
import com.example.appsem5.pakiety.Sport
import com.example.appsem5.pakiety.TreningMozgu
import com.example.appsem5.pakiety.ZdroweNawykiZywieniowe
import com.example.appsem5.pakiety.ZdrowiePsychiczne

class WidokWszystkichPakietow : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_packages)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val pakietSport = findViewById<Button>(R.id.PackagesButton1)
        pakietSport.text  = "Sport"
        pakietSport.setOnClickListener {
            startActivity(Intent(this, Sport::class.java))
        }

        val pakietTreningMozgu = findViewById<Button>(R.id.PackagesButton2)
        pakietTreningMozgu.text  = "Trening mózgu"
        pakietTreningMozgu.setOnClickListener {
            startActivity(Intent(this, TreningMozgu::class.java))
        }

        val pakietZdroweNawykiZywieniowe = findViewById<Button>(R.id.PackagesButton3)
        pakietZdroweNawykiZywieniowe.text  = "Zdrowe nawyki żywieniowe"
        pakietZdroweNawykiZywieniowe.setOnClickListener {
            startActivity(Intent(this, ZdroweNawykiZywieniowe::class.java))
        }

        val pakietZdrowiePsychiczne = findViewById<Button>(R.id.PackagesButton4)
        pakietZdrowiePsychiczne.text  = "Zdrowie psychiczne"
        pakietZdrowiePsychiczne.setOnClickListener {
            startActivity(Intent(this, ZdrowiePsychiczne::class.java))
        }
    }
}