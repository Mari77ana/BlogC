package com.example.blogc.navigation

sealed class Screen (val route: String) {
    object FormScreen: Screen("form_screen")
    object ProfileScreen: Screen("profile_screen")

    object UserListScreen: Screen("userList-screen")
}