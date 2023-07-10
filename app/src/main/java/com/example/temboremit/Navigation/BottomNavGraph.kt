package com.example.temboremit.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.temboremit.presentation.views.Home.HomeScreen
import com.example.temboremit.presentation.views.Home.ProfilePage
import com.example.temboremit.presentation.views.Home.SettingsPage


@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route)
        {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Report.route)
        {
            SettingsPage()
        }
        composable(route = BottomBarScreen.Profile.route)
        {
            ProfilePage()
        }
    }
}
