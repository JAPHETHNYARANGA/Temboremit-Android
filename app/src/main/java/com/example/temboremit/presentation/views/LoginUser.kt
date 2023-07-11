package com.example.temboremit.presentation.views

import android.app.Application
import android.content.Context
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.temboremit.presentation.viewModel.LoginViewModel
import com.example.temboremit.presentation.viewModel.RegisterViewModel
import dagger.hilt.android.internal.Contexts.getApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginUser(
    loginViewModel: LoginViewModel,
    navController: NavController
){
    var showForgotPassword by remember { mutableStateOf(false) }
    var forgetPassword by remember { mutableStateOf("") }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    val context = LocalContext.current

    val sharedPreferences = context.applicationContext.getSharedPreferences(
        "loginPreference",
        Context.MODE_PRIVATE
    )


    Box(){
        Column() {
            Column(
                Modifier
                    .weight(0.5f, true)
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                Text(text = "Sign in to your" , style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ))
                Text(text = " Account" , style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ))
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Sign in to your account" , style = TextStyle(
                    color = Color.Gray
                )
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Box(modifier = Modifier.padding(15.dp)){

                        Column() {

                            OutlinedTextField(
                                value = email,
                                onValueChange = { email = it },
                                label = { Text("Email") },


                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(0xFF1A202C),
                                    unfocusedBorderColor = Color(0xFF1A202C)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .onFocusChanged {
                                        if (it.isFocused) {
                                            keyboardController?.show()
                                        }
                                    }
                            )


                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },


                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color(0xFF1A202C),
                                    unfocusedBorderColor = Color(0xFF1A202C)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .onFocusChanged {
                                        if (it.isFocused) {
                                            keyboardController?.show()
                                        }
                                    }
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = "Forgot Password",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier
                                        .padding(end = 16.dp)

                                        .wrapContentWidth(Alignment.CenterHorizontally)
                                        .clickable { showForgotPassword = true }
                                )
                            }

                            Button(
                                onClick = {

                                 if (email.isNotEmpty() && password.isNotEmpty() && password.isNotEmpty()) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            loginViewModel.loginUser(
                                                email,
                                                password
                                            )?.let { response ->
                                                // Handle the response
                                                Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()

                                                if(response.status){
                                                    val editor = sharedPreferences.edit()
                                                    editor.putString("loginPreference", response.token)
                                                    editor.apply()
                                                    navController.navigate("home")

                                                }

                                            }
                                        }
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Please fill in all fields",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
//                                    navController.navigate("home")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)

                                ,
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.White, // Set the text color to white
                                    containerColor = Color(0xFF1A202C)
                                )
                            ) {
                                Text(text = "Login")
                            }

                            Row(Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center) {
                                Text(text = "Register User",
                                    style = TextStyle(color = Color.Black,
                                        fontWeight = FontWeight.Bold),
                                    modifier = Modifier.clickable {
                                        navController.navigate("register")
                                    }

                                )

                            }
                            

                        }

                    }

                }

            }


        }

        if (showForgotPassword) {
            Dialog(
                onDismissRequest = { showForgotPassword = false },
                properties = DialogProperties(
                    dismissOnClickOutside = false,
                    dismissOnBackPress = false
                )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            IconButton(
                                onClick = { showForgotPassword = false },
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = Color(0xFF1A202C)
                                )
                            }
                        }
                        OutlinedTextField(
                            value = forgetPassword,
                            onValueChange = { forgetPassword = it },
                            label = { Text("Enter your email") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Blue,
                                unfocusedBorderColor = Color.Black
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )

                        Button(
                            onClick = {
                                // ...
                                showForgotPassword = false // Hide the popup
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = Color(0xFF1A202C)
                            )
                        ) {
                            Text(text = "Submit")
                        }
                    }
                }
            }
        }
    }

}