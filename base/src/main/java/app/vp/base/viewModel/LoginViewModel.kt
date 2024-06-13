package app.vp.base.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import app.vp.base.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {

//    fun buildSignInRequest(): BeginSignInRequest {
//        return BeginSignInRequest.Builder()
//            .setGoogleIdTokenRequestOptions(
//                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    .setFilterByAuthorizedAccounts(false)
//                    .setServerClientId("725558427498-ratlienpiv3qa8v16f23kglca55igd6f.apps.googleusercontent.com")
//                    .build()
//            )
//            .setAutoSelectEnabled(true)
//            .build()
//    }

}