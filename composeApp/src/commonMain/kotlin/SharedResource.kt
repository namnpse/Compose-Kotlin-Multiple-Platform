import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cmp_kmp.composeapp.generated.resources.Res
import cmp_kmp.composeapp.generated.resources.compose_multiplatform
import cmp_kmp.composeapp.generated.resources.headphone
import org.jetbrains.compose.resources.painterResource

@Composable
fun SharedResource() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shared Resource"
        )
        Image(painter = painterResource(Res.drawable.headphone), contentDescription = "compose_multiplatform")
    }
}