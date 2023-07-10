package com.example.temboremit


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
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
import registerUser


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val registerViewModel: RegisterViewModel by viewModels()

    private lateinit var sharedPreferences: SharedPreferences


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
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

                    sharedPreferences = getSharedPreferences("loginToken", Context.MODE_PRIVATE)
                    val loginToken = getLoginToken()
                    if (loginToken != null) {
                        // User is already logged in, navigate to home
                        navController.navigate("home")
                        Toast.makeText(applicationContext, getLoginToken().toString(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, getLoginToken().toString(), Toast.LENGTH_LONG).show()
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

    private fun getLoginToken(): String? {
        return sharedPreferences.getString("LoginPrefs", null)
    }
}