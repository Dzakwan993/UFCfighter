package com.example.ufcfighter.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomBottomNavigation(
    currentScreen: String,
    onNavigateTo: (String) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.List, contentDescription = "List") },
            label = { Text("List") },
            selected = currentScreen == "List",
            onClick = { onNavigateTo("List") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Info, contentDescription = "Grid") },
            label = { Text("Grid") },
            selected = currentScreen == "Grid",
            onClick = { onNavigateTo("Grid") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Info, contentDescription = "About") },
            label = { Text("About") },
            selected = currentScreen == "About",
            onClick = { onNavigateTo("About") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomBottomNavigation() {
    CustomBottomNavigation(currentScreen = "List", onNavigateTo = { })
}
