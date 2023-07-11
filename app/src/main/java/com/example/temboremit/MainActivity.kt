package com.example.temboremit


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.temboremit.Navigation.MainScreen
import com.example.temboremit.presentation.viewModel.LoginViewModel
import com.example.temboremit.presentation.viewModel.RegisterViewModel
import com.example.temboremit.presentation.views.LoginUser
import com.example.temboremit.ui.theme.TemboremitTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import registerUser


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val registerViewModel: RegisterViewModel by viewModels()

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

                    if (loginToken != null) {

                        Toast.makeText(applicationContext, getLoginToken(sharedPreferences).toString(), Toast.LENGTH_LONG).show()

                        NavHost(navController = navController, startDestination = "home" ){
                            composable("home") {
                                MainScreen()
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
                                MainScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getLoginToken(sharedPreferences: SharedPreferences): String? {
        return sharedPreferences.getString("loginPreference", null)
    }
}

