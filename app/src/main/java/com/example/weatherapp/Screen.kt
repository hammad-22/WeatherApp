package com.example.weatherapp


/**
 * navigation tutorial from https://www.youtube.com/watch?v=4gUeyNkGE3g
 */
sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
}
