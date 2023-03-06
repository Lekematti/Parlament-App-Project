// 20.2.2023
// Leo Koskimäki
// 2201352
// MyApp is used in ParlamentDatabase. Gives context.
package com.example.parlament_app

import android.app.Application
import android.content.Context
import android.util.Log

class MyApp: Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("QQQ", "MyApp onCreate()")
        appContext = applicationContext
    }
}