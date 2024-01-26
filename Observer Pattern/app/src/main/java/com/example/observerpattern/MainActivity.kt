package com.example.observerpattern

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity(), Subscriber {
    private var field: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        field = findViewById(R.id.weather_field)

        val weather = WeatherObserver.getInstance()
        weather.runWithActivityThread(this)
        weather.subscribe(this)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondWeatherActivity::class.java)
            weather.unsubscribe(this)
            startActivity(intent)
        }
    }

    override fun update(new: Int) {
        field!!.text = "Погода: $new"
    }
}