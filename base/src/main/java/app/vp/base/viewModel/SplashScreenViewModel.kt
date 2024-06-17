package app.vp.base.viewModel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import app.vp.base.constants.Constants
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(

) : ViewModel() {

    @Composable
    fun remoteConfigWitnFirebase() {

        val remoteConfig = FirebaseRemoteConfig.getInstance()

        val remoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        remoteConfig.setConfigSettingsAsync(remoteConfigSettings)

//        val remoteConfigDefaults = mapOf(
//            "webClientId" to "webClientId",
//        )
//        remoteConfig.setDefaultsAsync(remoteConfigDefaults)

        LaunchedEffect(Unit) {
            remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val webClientId = remoteConfig.getString("webClientId")
                    Constants.WEB_CLIENT_ID = webClientId
                } else {

                }
            }
        }
    }
}