import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cmp_kmp.composeapp.generated.resources.Res
import cmp_kmp.composeapp.generated.resources.compose_multiplatform
import cmp_kmp.composeapp.generated.resources.headphone
import cmp_kmp.composeapp.generated.resources.shared_resources
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SharedResource() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.shared_resources)
        )
        Image(painter = painterResource(Res.drawable.headphone), contentDescription = "compose_multiplatform")
    }
}