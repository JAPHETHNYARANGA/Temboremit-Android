package com.example.temboremit.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.temboremit.presentation.views.Home.EditProfilePage
import com.example.temboremit.presentation.views.Home.HomeScreen
import com.example.temboremit.presentation.views.Home.ProfilePage
import com.example.temboremit.presentation.views.Home.SettingsPage
import com.example.temboremit.presentation.views.Home.TransactionsPage


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
        composable(route = BottomBarScreen. Transaction.route)
        {
            TransactionsPage()
        }
        composable(route = BottomBarScreen.Profile.route)
        {
            ProfilePage(navController = navController)
        }
        composable(route = BottomBarScreen.EditProfile.route){
            EditProfilePage()
        }
    }
}
