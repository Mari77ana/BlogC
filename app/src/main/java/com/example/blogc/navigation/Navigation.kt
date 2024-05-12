package com.example.blogc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogc.features.formscreen.FormScreen
import com.example.blogc.features.formscreen.FormViewModel
import com.example.blogc.features.profilescreen.ProfileScreen

@Composable // For showing screens
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FormScreen.route) {

        composable(route = Screen.FormScreen.route) {
            FormScreen(
                formViewModel = FormViewModel(),
                navigateToProfile = {
                    navController.navigate(Screen.ProfileScreen.route)
                }
            )

        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(
                navigateToUserListScreen = {},
                navigateToBlogScreen = {}
            )
        }

    }

}