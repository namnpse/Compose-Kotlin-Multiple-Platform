import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import di.initDI
import expect_actual.BatteryManager

fun MainViewController() = ComposeUIViewController(
    configure = {
        initDI()
    }
) {
    App(batteryManager = remember { BatteryManager() })
}