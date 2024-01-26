package com.example.observerpattern

import android.app.Activity
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

class WeatherObserver private constructor(){
    private var weatherState: Int = 0
    private var subscribers: ArrayList<Subscriber> = arrayListOf()
    private var running = false

    companion object {
        @Volatile private var instance: WeatherObserver? = null
        fun getInstance(): WeatherObserver =
            instance ?: synchronized(this) {
                if (instance == null)
                    instance = WeatherObserver()
                return instance as WeatherObserver
            }
    }

    fun subscribe(sub: Subscriber){
        if (!subscribers.contains(sub))
            subscribers.add(sub)
    }

    fun unsubscribe(sub: Subscriber){
        subscribers.remove(sub)
    }

    private fun notifySubscribers(){
        val count = subscribers.size
        Log.println(Log.INFO,"local_debugging", "Notifying $count subscribers")
        for (sub in subscribers){
            sub.update(weatherState)
        }
    }

    private fun calculateWeather(): Int{
        return System.currentTimeMillis().toInt() % 35
    }

    private fun updateWeather(new: Int){
        weatherState = new
        notifySubscribers()
    }

    fun runWithActivityThread(act: Activity){
        if (running) return

        val myTimer = Timer()

        myTimer.schedule(object : TimerTask() {
            override fun run() {
                act.runOnUiThread {
                    updateWeather(calculateWeather())
                }
            }
        }, 0, 5000)
        running = true
    }
}

interface Subscriber{
    fun update(new: Int)
}