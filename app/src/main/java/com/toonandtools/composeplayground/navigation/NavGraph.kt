package com.toonandtools.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toonandtools.composeplayground.ApiSimulatorApp
import com.toonandtools.composeplayground.App
import com.toonandtools.composeplayground.ComposePlaygroundApp
import com.toonandtools.composeplayground.CounterApp
import com.toonandtools.composeplayground.SpaceCreation
import com.toonandtools.composeplayground.userflow.UserDetailScreen
import com.toonandtools.composeplayground.userflow.UserListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            ComposePlaygroundApp(navController)
        }

        composable(Screen.ArtSpace.route) {
            SpaceCreation(navController)
        }

        composable(Screen.Affirmations.route) {
            App(navController)
        }

        composable(Screen.Counter.route) {
            CounterApp(navController)
        }

        composable(Screen.ApiSimulator.route) {
            ApiSimulatorApp(navController)
        }

        composable(Screen.UserList.route) {
            UserListScreen(navController)
        }

        composable("user_detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            UserDetailScreen(name, navController)
        }
    }
}