package com.namnpse.cmp_kmp

import App
import expect_actual.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import data_store.createDataStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                batteryManager = remember {
                    BatteryManager(this)
                },
                prefs = remember {
                    createDataStore(applicationContext)
                }
            )
        }
    }
}