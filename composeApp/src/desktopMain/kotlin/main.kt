import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data_store.DATA_STORE_FILE_NAME
import data_store.createDataStore
import di.initDI
import expect_actual.BatteryManager

fun main() = application {

    initDI()

    val prefs = createDataStore {
        DATA_STORE_FILE_NAME
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "CMP_KMP",
    ) {
        App(
            batteryManager = remember { BatteryManager() },
            prefs = remember { prefs }
        )
    }
}