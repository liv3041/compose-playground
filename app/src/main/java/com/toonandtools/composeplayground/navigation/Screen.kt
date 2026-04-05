package com.toonandtools.composeplayground.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ArtSpace : Screen("art_space")
    object Affirmations : Screen("affirmations")
    object Counter : Screen("counter")
    object ApiSimulator : Screen("api_simulator")
}