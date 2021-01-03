package com.jdemaagd.shoestore.common

import android.app.Application

import timber.log.Timber

// Note: global access to logging. Do NOT abuse this class by adding other stuff!!
class ShoeStoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}