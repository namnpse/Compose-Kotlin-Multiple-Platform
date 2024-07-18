import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    batteryManager: BatteryManager
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
        }
    }
}