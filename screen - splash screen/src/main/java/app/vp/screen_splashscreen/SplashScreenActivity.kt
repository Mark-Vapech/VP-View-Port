package app.vp.screen_splashscreen

import android.content.Context
import android.content.Intent
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
import androidx.lifecycle.viewmodel.compose.viewModel
import app.vp.base.loading.loadingAnimation
import app.vp.base.viewModel.SplashScreenViewModel
import app.vp.screen_register.ScreenLoginAndRegister
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreenActivity(
    modifier: Modifier = Modifier,
    context: Context,
) {
    var loading by remember { mutableStateOf(true) }
    val viewModel = viewModel<SplashScreenViewModel>()
    viewModel.remoteConfigWitnFirebase()

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
            val intent = Intent(context, ScreenLoginAndRegister::class.java)
            context.startActivity(intent)
        }
    }
}
