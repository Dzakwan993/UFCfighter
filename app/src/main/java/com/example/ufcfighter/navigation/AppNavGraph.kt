package com.example.ufcfighter.navigation

import FighterViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ufcfighter.ui.Screens.FighterDetailScreen
import com.example.ufcfighter.ui.screens.FighterListScreen


@Composable
fun AppNavGraph(fighterViewModel: FighterViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "fighter_list") {
        composable("fighter_list") {
            FighterListScreen(fighterViewModel, navController)
        }
        composable("detail/{fighterId}") { backStackEntry ->
            val fighterId = backStackEntry.arguments?.getString("fighterId")?.toIntOrNull()
            if (fighterId != null) {
                FighterDetailScreen(fighterId, fighterViewModel, navController)
            }
        }
    }
}
