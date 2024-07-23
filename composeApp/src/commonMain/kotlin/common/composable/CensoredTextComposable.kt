package common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import network.CensoredWordKtorClient
import util.NetworkError
import util.onError
import util.onSuccess

@Composable
fun CensoredTextComposable(
    ktorClient: CensoredWordKtorClient,
    modifier: Modifier = Modifier,
) {
    var censoredWord by remember { mutableStateOf<String?>(null) }
    var uncensoredWord by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<NetworkError?>(null) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
    ) {
        TextField(
            value = uncensoredWord,
            onValueChange = { uncensoredWord = it },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text("Uncensored word")
            }
        )
        Button(
            onClick = {
                scope.launch {
                    isLoading = true
                    errorMessage = null
                    ktorClient.startCensoringWord(uncensoredWord)
                        .onSuccess { result ->
                            censoredWord = result
                        }
                        .onError {
                            errorMessage = it
                        }
                    isLoading = false
                }
            }
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 1.dp,
                    color = MaterialTheme.colors.primary
                )
            }
            censoredWord?.let {
                Text("Censored word: $it")
            }
            errorMessage?.let {
                Text(
                    text = "Error: $it",
                    color = MaterialTheme.colors.error
                )
            }
        }
    }
}