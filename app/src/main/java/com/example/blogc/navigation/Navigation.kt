package com.example.blogc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.blogc.features.blogscreen.BlogScreen
import com.example.blogc.features.blogscreen.BlogViewModel
import com.example.blogc.features.formscreen.FormScreen
import com.example.blogc.features.formscreen.FormViewModel
import com.example.blogc.features.profilescreen.ProfileScreen
import com.example.blogc.features.userlistscreen.UserListScreen

@Composable // For showing screens
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FormScreen.route) {

        composable(route = Screen.FormScreen.route) {
            FormScreen(
                formViewModel = FormViewModel(),
                navigateToProfile = { name, lastname, email ->
                    navController.navigate("${Screen.ProfileScreen.route}/$name/$lastname/$email")
                }
            )

        }
        composable(route = "${Screen.ProfileScreen.route}/{name}/{lastname}/{email}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("lastname") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )

        ) { backStackEntry ->

            ProfileScreen(
                backStackEntry.arguments?.getString("name"),
                backStackEntry.arguments?.getString("lastname"),
                backStackEntry.arguments?.getString("email"),
                navigateToUserListScreen = {
                    navController.navigate(Screen.UserListScreen.route)
                },
                navigateToBlogScreen = {
                    navController.navigate(Screen.BlogScreen.route)
                }
            )
        }

        composable(route = Screen.BlogScreen.route) {
            BlogScreen(
                blogViewModel = BlogViewModel(),
                onTitleChanged = { /*TODO*/ },
                onDescriptionChanged = { /*TODO*/ },
                navigateToProfileScreen = { /*TODO*/ }) {

            }
        }

        composable(route = Screen.UserListScreen.route) {
            UserListScreen()
        }


    }

}