import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initDI

fun main() = application {

    initDI()

    Window(
        onCloseRequest = ::exitApplication,
        title = "CMP_KMP",
    ) {
        App(batteryManager = remember { BatteryManager() })
    }
}