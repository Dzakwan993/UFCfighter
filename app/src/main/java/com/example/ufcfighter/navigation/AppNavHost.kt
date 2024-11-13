package com.example.ufcfighter.navigation

import AboutScreen

import FighterViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ufcfighter.ui.Screens.FighterDetailScreen

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController



import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.tooling.preview.Preview

import com.example.ufcfighter.ui.screens.FighterListScreen

@Composable
fun AppNavigation(fighterViewModel: FighterViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val currentRoute = navController.currentBackStackEntry?.destination?.route
                    Text(
                        when (currentRoute) {
                            "list" -> "Fighter List"
                            "about" -> "About"
                            else -> "Fighter Detail"
                        }
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                val currentRoute = navController.currentBackStackEntry?.destination?.route
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "List") },
                    label = { Text("List") },
                    selected = currentRoute == "list",
                    onClick = { navController.navigate("list") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                    label = { Text("About") },
                    selected = currentRoute == "about",
                    onClick = { navController.navigate("about") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = "list", modifier = Modifier.padding(paddingValues)) {
            composable("list") { FighterListScreen(fighterViewModel, navController) }
            composable("detail/{fighterId}") { backStackEntry ->
                val fighterId = backStackEntry.arguments?.getString("fighterId")?.toInt() ?: 0
                FighterDetailScreen(fighterId, fighterViewModel, navController)
            }
            composable("about") { AboutScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val fighterViewModel = FighterViewModel()
    AppNavigation(fighterViewModel)
}




