package com.example.ufcfighter


import FighterViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.ufcfighter.navigation.AppNavigation


import androidx.activity.compose.setContent

import androidx.compose.material3.Surface


class MainActivity : ComponentActivity() {
    private val fighterViewModel: FighterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(fighterViewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val fighterViewModel = FighterViewModel()
    AppNavigation(fighterViewModel)
}


