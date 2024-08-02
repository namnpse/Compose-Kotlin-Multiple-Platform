import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import data_store.createDataStore
import di.initDI
import expect_actual.BatteryManager
import io.ktor.client.engine.darwin.Darwin
import navigation.NavigationApp
import navigation.components.RootComponent
import network.CensoredWordKtorClient
import network.initKtorClient

fun MainViewController() = ComposeUIViewController(
    configure = {
        initDI()
    }
) {

    App(
        batteryManager = remember { BatteryManager() },
        prefs = remember {
            createDataStore()
        },
        ktorClient = remember {
            val httpClient = initKtorClient(Darwin.create())
            CensoredWordKtorClient(httpClient)
        }
    )

/*    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
    NavigationApp(root)*/
}