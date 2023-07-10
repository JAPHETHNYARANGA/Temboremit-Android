package com.example.temboremit.presentation.views.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.temboremit.R
import com.example.temboremit.presentation.views.TopNavBar.TopNavBar


@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // TopNavBar positioned at the top
        Row() {
            TopNavBar()
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Home Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}

