package app.vp.screen_register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.vp.screen_register.ui.theme.VPViewPortTheme

class ScreenLoginAndRegister : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            LoginScreen(Modifier, loginViewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VPViewPortTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
//            Scaffold {
//                LoginScreen(Modifier.padding(it), loginViewModel)
//            }
        }
    }
}