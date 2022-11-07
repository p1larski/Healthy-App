package com.example.appsem5
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appsem5.pakiety.aktywnePakiety.WidokAktywnychPakietow
import com.example.appsem5.pakiety.widokiPoPowiadomieniach.SportNotifcation


class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(resources.getDrawable(R.drawable.gradient))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val MainButton = findViewById<Button>(R.id.MainButton)
        MainButton.setOnClickListener {
            startActivity(Intent(this, WidokAktywnychPakietow::class.java))
        }
    }
}







