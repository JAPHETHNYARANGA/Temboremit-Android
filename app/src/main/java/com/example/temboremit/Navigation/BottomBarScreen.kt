package com.example.temboremit.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.temboremit.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {

    // for home
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    // for report
    object Report: BottomBarScreen(
        route = "report",
        title = "cards",
        icon = R.drawable.card,
        icon_focused = R.drawable.carddark
    )

    // for report
    object Transaction: BottomBarScreen(
        route = "transaction",
        title = "Transactions",
        icon = R.drawable.transaction,
        icon_focused = R.drawable.transactiondark
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )

    object EditProfile: BottomBarScreen(
        route = "editProfile",
        title = "editProfile",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )

}