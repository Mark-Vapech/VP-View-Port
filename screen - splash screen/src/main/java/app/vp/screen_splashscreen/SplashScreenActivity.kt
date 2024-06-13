package app.vp.screen_splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.vp.base.loading.loadingAnimation
import app.vp.screen_register.login.LoginScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreenActivity(
    modifier: Modifier = Modifier,
) {
    var loading by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .background(Color.White),
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
            LoginScreen(modifier = Modifier)
        }
    }
}
