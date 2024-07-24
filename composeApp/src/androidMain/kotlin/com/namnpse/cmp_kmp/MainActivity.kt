package com.namnpse.cmp_kmp

import App
import expect_actual.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import data_store.createDataStore
import io.ktor.client.engine.okhttp.OkHttp
import network.CensoredWordKtorClient
import network.initKtorClient

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
                },
                ktorClient = remember {
                    val httpClient = initKtorClient(OkHttp.create())
                    CensoredWordKtorClient(httpClient)
                }
            )
        }
    }
}