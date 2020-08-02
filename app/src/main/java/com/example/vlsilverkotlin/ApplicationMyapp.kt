package com.example.vlsilverkotlin

import android.app.Application
import timber.log.Timber

class ApplicationMyapp : Application(){
    override fun onCreate(){
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}