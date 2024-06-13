package app.vp.screen_register.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.vp.base.textCustom.BasicTextFieldCustom
import com.stevdzasan.onetap.GoogleUser
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.getUserFromTokenId
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 30.dp)
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val state = rememberOneTapSignInState()

        BasicTextFieldCustom(name = "Username", value = username, onValueChange = { username = it })

        Spacer(modifier = Modifier.height(10.dp))

        BasicTextFieldCustom(name = "Password", value = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.height(15.dp))

        SignInWithGoogleButton(state = state)

        Spacer(modifier = Modifier.height(15.dp))

        SignInWithFacebookButton(){}

        LoginButton(){

        }

    }
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { onClick() }) {
            Text("Login")
        }
    }
}

@Composable
fun SignInWithGoogleButton(state: OneTapSignInState) {
    var user: GoogleUser? by remember { mutableStateOf(null) }

    OneTapSignInWithGoogle(
        state = state,
        clientId = "725558427498-ratlienpiv3qa8v16f23kglca55igd6f.apps.googleusercontent.com",
        rememberAccount = false,
        onTokenIdReceived = {
            user = getUserFromTokenId(tokenId = it)
            Log.d("MainActivity", user.toString())
        },
        onDialogDismissed = {
            Log.d("MainActivity", it)
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(
            onClick = { state.open() }) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Google",
                    modifier = Modifier.size(24.dp)
                )
                if (state.opened) {
                    CircularProgressIndicator(
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sign in With Google")
            }
        }
    }
}

@Composable
fun SignInWithFacebookButton(onClick: () -> Unit) {

}