package com.example.ufcfighter.ui.screens

import FighterViewModel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.ufcfighter.model.Fighter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.remember

import androidx.navigation.NavController

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun FighterListScreen(fighterViewModel: FighterViewModel, navController: NavController) {
    var query by remember { mutableStateOf("") }
    val filteredFighters = remember(query) { fighterViewModel.searchFighters(query) }
    var showGrid by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Fighters") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = { showGrid = !showGrid },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(if (showGrid) "liat pake list?" else "Liat pake grid?")
        }

        if (showGrid) {
            FighterGrid(filteredFighters, navController)
        } else {
            FighterVerticalList(filteredFighters, navController)
        }
    }
}

@Composable
fun FighterVerticalList(fighters: List<Fighter>, navController: NavController) {
    Text(text = "ini lazyrow", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold, fontSize = 20.sp)
    LazyRow {
        items(fighters) { fighter ->
            

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("detail/${fighter.id}")
                    }
            ) {
                
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = fighter.image),
                        contentDescription = fighter.name,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(fighter.name, style = MaterialTheme.typography.h6)
                }
            }
        }
    }

    Text(text = "ini lazycolumn", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold, fontSize = 20.sp)
    LazyColumn {
        items(fighters) { fighter ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("detail/${fighter.id}")
                    }
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = fighter.image),
                        contentDescription = fighter.name,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(fighter.name, style = MaterialTheme.typography.h6)
                }
            }
        }
    }

    
}

@Composable
fun FighterGrid(fighters: List<Fighter>, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(fighters) { fighter ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("detail/${fighter.id}")
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = fighter.image),
                        contentDescription = fighter.name,
                        modifier = Modifier
                            .size(120.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        fighter.name,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}


