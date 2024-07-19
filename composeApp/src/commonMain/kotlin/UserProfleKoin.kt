import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dependencies.UserViewModel
import org.koin.compose.KoinContext
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun UserProfileKoin() {
    KoinContext {
        NavHost(
            navController = rememberNavController(),
            startDestination = "Welcome"
        ) {
            composable(route = "Welcome") {
                val viewModel = koinViewModel<UserViewModel>()
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hello ${viewModel.getUserName()}"
                    )
                }
            }
        }
    }
}