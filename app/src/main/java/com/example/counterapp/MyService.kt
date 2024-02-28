package com.example.counterapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    private val binder = MyServiceBinder()
    private var count = 0

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun increment() {
        count++
    }

    fun decrement() {
        if (count > 0) count--
    }

    fun showCounter() {
        Toast.makeText(this, "$count", Toast.LENGTH_SHORT).show()
    }

    inner class MyServiceBinder : Binder() {
        fun getService() = this@MyService
    }
}