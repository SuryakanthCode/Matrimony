package com.example.matrimonysampleapp.userinterface.presentation.utils

sealed class RouteScreen(val route: String) {
    object ProfileScreen: RouteScreen("profile_screen")
    object GestureScreen: RouteScreen("gesture_screen")
    object HomeScreen: RouteScreen("home_screen")
}