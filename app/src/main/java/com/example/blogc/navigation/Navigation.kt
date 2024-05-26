package com.example.blogc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                navigateToProfile = {name, lastname, email ->
                    navController.navigate("${Screen.ProfileScreen.route}/$name/$lastname/$email")
                }
            )

        }
        composable(route = "${Screen.ProfileScreen.route }/{name}/{lastname}/{email}",
            arguments = listOf(
                navArgument("name"){ type = NavType.StringType},
                navArgument("lastname") { type = NavType.StringType},
                navArgument("email") { type = NavType.StringType}
            )

            ) { backStackEntry ->

            ProfileScreen(
                backStackEntry.arguments?.getString("name"),
                backStackEntry.arguments?.getString("lastname"),
                backStackEntry.arguments?.getString("email"),
                navigateToUserListScreen = {},
                navigateToBlogScreen = {}
            )
        }

    }

}