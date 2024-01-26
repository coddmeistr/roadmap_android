package com.example.observerpattern

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondWeatherActivity : AppCompatActivity(), Subscriber {
    private var field: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_weather)
        field = findViewById(R.id.weather_field)

        val weather = WeatherObserver.getInstance()
        weather.runWithActivityThread(this)
        weather.subscribe(this)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@SecondWeatherActivity, ThirdWeatherActivity::class.java)
            weather.unsubscribe(this)
            startActivity(intent)
        }
    }

    override fun update(new: Int) {
        field!!.text = "Погода: $new"
    }
}