package com.example.weatherapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.screens.HomeScreenUI
import com.example.weatherapp.screens.SplashScreenUI

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreenUI(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreenUI()
        }
    }
}
