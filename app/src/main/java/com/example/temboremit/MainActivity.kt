package com.example.temboremit



import android.annotation.SuppressLint
import android.content.Context
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.temboremit.Navigation.MainScreen
import com.example.temboremit.broadCasts.ConnectivityChangeReceiver
import com.example.temboremit.presentation.viewModel.LoginViewModel
import com.example.temboremit.presentation.viewModel.RegisterViewModel
import com.example.temboremit.presentation.views.Home.EditProfilePage
import com.example.temboremit.presentation.views.LoginUser
import com.example.temboremit.ui.theme.TemboremitTheme
import com.example.temboremit.utils.checkInternetConnection
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import registerUser


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var connectivityChangeReceiver: ConnectivityChangeReceiver
    private val loginViewModel: LoginViewModel by viewModels()
    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var isInternetConnected: MutableState<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemboremitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val sharedPreferences = getSharedPreferences("loginPreference", Context.MODE_PRIVATE)

                    val loginToken = getLoginToken(sharedPreferences)

                    isInternetConnected = remember { mutableStateOf(checkInternetConnection(this)) }
                    connectivityChangeReceiver = ConnectivityChangeReceiver(isInternetConnected)

                    val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                    registerReceiver(connectivityChangeReceiver, intentFilter)

                    if (loginToken != null) {
                        Toast.makeText(applicationContext, getLoginToken(sharedPreferences).toString(), Toast.LENGTH_LONG).show()
                        NavHost(navController = navController, startDestination = "home" ){
                            composable("home") {
                                MainScreen(isInternetConnected = isInternetConnected)
                            }
                        }
                    } else {
                        // User is not logged in, navigate to login
                        NavHost(navController, startDestination = "login") {
                            composable("login") {
                                LoginUser(
                                    loginViewModel = loginViewModel,
                                    navController = navController
                                )
                            }
                            composable("register") {
                                registerUser(
                                    registerviewModel = registerViewModel,
                                    navController = navController
                                )
                            }
                            composable("home") {
                                MainScreen(isInternetConnected = isInternetConnected)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityChangeReceiver)
    }


    private fun getLoginToken(sharedPreferences: SharedPreferences): String? {
        return sharedPreferences.getString("loginPreference", null)
    }
}