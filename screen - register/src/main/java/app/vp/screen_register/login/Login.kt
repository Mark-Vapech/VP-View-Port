package app.vp.screen_register.login

import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.vp.base.textCustom.BasicTextFieldCustom
import app.vp.base.viewModel.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.stevdzasan.onetap.GoogleUser
import com.stevdzasan.onetap.rememberOneTapSignInState
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Suppress("NAME_SHADOWING")
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {

    val viewModel = viewModel<LoginViewModel>()
    var user by remember { mutableStateOf(FirebaseAuth.getInstance().currentUser) }
    val launcher = rememberFirebaseAuth(onAuthSuccess =
    { succes ->
        user = succes.user
    }, onAuthError = { error ->
        user = null
    })

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
        val user: GoogleUser? by remember { mutableStateOf(null) }
        val token = "725558427498-ratlienpiv3qa8v16f23kglca55igd6f.apps.googleusercontent.com"
        val context = LocalContext.current

        val state = rememberOneTapSignInState()

        BasicTextFieldCustom(name = "Username", value = username, onValueChange = { username = it })

        Spacer(modifier = Modifier.height(10.dp))

        BasicTextFieldCustom(name = "Password", value = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.height(15.dp))

        SignInWithGoogleButton(token, context, launcher, viewModel)

        Spacer(modifier = Modifier.height(15.dp))

        SignInWithFacebookButton() {}

        LoginButton() {

        }

    }
}

@Composable
fun rememberFirebaseAuth(
    onAuthSuccess: (AuthResult) -> Unit,
    onAuthError: (ApiException) -> Unit,
): ManagedActivityResultLauncher<Intent, ActivityResult> {
    val scope = rememberCoroutineScope()
    return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)!!

            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            scope.launch {
                val authResult = FirebaseAuth.getInstance().signInWithCredential(credential).await()
                onAuthSuccess(authResult)
            }
        } catch (e: ApiException) {
            onAuthError(e)
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

@Suppress("UNUSED_EXPRESSION")
@Composable
fun SignInWithGoogleButton(
    token: String,
    context: Context,
    launcher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    viewModel: LoginViewModel,
    ) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(
            onClick = {
                viewModel.signIn(context = context, token = token, launcher = launcher)
            }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Google",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sign in With Google")
            }
        }
    }
}

@Composable
fun SignInWithFacebookButton(onClick: () -> Unit) {

}