package com.example.temboremit.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.temboremit.presentation.views.Home.HomePage


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomePage()
        }
        composable(route = BottomBarScreen.Profile.route) {
            HomePage()
        }
        composable(route = BottomBarScreen.Settings.route) {
            HomePage()
        }
    }
}