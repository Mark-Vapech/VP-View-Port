package app.vp.screen_register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import app.vp.base.viewModel.LoginViewModel
import app.vp.screen_home.mainHome.MainHomeActivity
import app.vp.screen_register.login.LoginScreen
import app.vp.screen_register.ui.theme.VPViewPortTheme

class ScreenLoginAndRegister : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VPViewPortTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        this,
                        viewModel
                    )
                }
            }
        }

        eventClick()
    }

    private fun eventClick() {
        viewModel.onClick.observe(this, Observer {
            when (it) {
                "successFirebase" -> {
                    val intent = Intent(this, MainHomeActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}
@Composable
fun Greeting(modifier: Modifier = Modifier, context: Context, viewModel: LoginViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginScreen(modifier = modifier, context = context, viewModel.onClick)
    }

}
