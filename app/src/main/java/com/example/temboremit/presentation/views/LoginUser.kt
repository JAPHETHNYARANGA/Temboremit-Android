package com.example.temboremit.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginUser(){
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
                        Text(text = "Google")
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )

                ) {
                    Box(modifier = Modifier.padding(15.dp)){
                        Text(text = "Facebook")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Box(modifier = Modifier.padding(15.dp)){
                        Text(text = "Twitter")
                    }

                }
            }


        }
    }

}