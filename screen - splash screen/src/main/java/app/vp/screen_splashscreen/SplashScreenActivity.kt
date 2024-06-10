package app.vp.screen_splashscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.vp.base.loading.loadingAnimation
import app.vp.screen_register.ScreenLoginAndRegister
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreenActivity(
    modifier: Modifier = Modifier
) {
    var loading by remember { mutableStateOf(true) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LaunchedEffect(loading) {
            if (loading) {
                delay(2.seconds)
                loading = false
            }

        }

        if (loading) {
            loadingAnimation()
        } else {
            ScreenLoginAndRegister()
        }
    }
}
