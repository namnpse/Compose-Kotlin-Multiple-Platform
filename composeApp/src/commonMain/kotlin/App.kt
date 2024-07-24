import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import common.composable.CensoredTextComposable
import common.composable.Greeting
import common.composable.UserProfileKoin
import data_store.DataStoreComposable
import expect_actual.BatteryManager
import network.CensoredWordKtorClient
import org.jetbrains.compose.ui.tooling.preview.Preview
import shared_resources.SharedResource

@Composable
@Preview
fun App(
    batteryManager: BatteryManager,
    prefs: DataStore<Preferences>,
    ktorClient: CensoredWordKtorClient,
) {
    MaterialTheme {
        val greetingMessage = Greeting.greet()
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = greetingMessage
            )
            Text(
                text = "The current battery level is ${batteryManager.getBatteryLevel()}"
            )
            SharedResource()
            UserProfileKoin()
            DataStoreComposable(prefs)
            CensoredTextComposable(ktorClient)
        }
    }
}