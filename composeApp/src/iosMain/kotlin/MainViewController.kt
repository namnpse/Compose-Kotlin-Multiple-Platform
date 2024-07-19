import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import di.initDI

fun MainViewController() = ComposeUIViewController(
    configure = {
        initDI()
    }
) {
    App(batteryManager = remember { BatteryManager() })
}