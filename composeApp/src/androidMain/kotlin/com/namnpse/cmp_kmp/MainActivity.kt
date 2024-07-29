package com.namnpse.cmp_kmp

import App
import expect_actual.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import data_store.createDataStore
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import network.CensoredWordKtorClient
import network.initKtorClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var isChecking = false
        lifecycleScope.launch {
            delay(3000L)
            isChecking = true
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                isChecking
            }
        }

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