package com.namnpse.cmp_kmp

import android.app.Application
import di.initDI
import org.koin.android.ext.koin.androidContext

class KMPApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initDI {
            androidContext(this@KMPApplication)
        }
    }
}