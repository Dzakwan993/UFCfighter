package com.example.ufcfighter.ui.Screens

import FighterViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@Composable
fun FighterDetailScreen(fighterId: Int, fighterViewModel: FighterViewModel, navController: NavHostController) {
    val fighter = fighterViewModel.fighters.find { it.id == fighterId }

    fighter?.let {
        Column {
            TopAppBar(
                title = { Text("Fighter Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

            Image(
                painter = painterResource(id = fighter.image),
                contentDescription = fighter.name,
                modifier = Modifier
                    .padding(16.dp)
                    .height(200.dp)
            )

            Text("Name: ${fighter.name}", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("Bio: ${fighter.bio}", style = MaterialTheme.typography.body1, modifier = Modifier.padding(16.dp))
        }
    } ?: run {
        Text("Fighter not found", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.h6)
    }
}




