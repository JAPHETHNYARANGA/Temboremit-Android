package com.example.temboremit.presentation.views.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import com.example.temboremit.Navigation.BottomBarScreen
import com.example.temboremit.R


@Composable
fun ProfilePage(navController :NavController,){


    Column() {
//
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User image",
                modifier = Modifier.size(50.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Text(text = "Japheth Nyaranga",style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
        }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Text(text = "User", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(Modifier.padding(start = 16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User image",
                modifier = Modifier
                    .size(20.dp)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Japheth ")
            Text(text = " Nyaranga")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.padding(start = 16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "User email",
                modifier = Modifier
                    .size(20.dp)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Japheth@gmail.com ")

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(Modifier.padding(start = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = "User map",
                modifier = Modifier
                    .size(20.dp)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Kenya")

        }


        Spacer(modifier = Modifier.height(120.dp))


        Column(Modifier.padding(bottom = 16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        navController.navigate(BottomBarScreen.EditProfile.route)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Edit Profile")
                }
                Spacer(modifier = Modifier.width(8.dp)) // Add spacer between buttons
                Button(
                    onClick = { /* Button click action */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Logout")
                }
            }
        }




    }

}