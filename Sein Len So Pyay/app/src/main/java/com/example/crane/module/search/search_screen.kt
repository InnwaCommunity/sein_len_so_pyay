package com.example.crane.module.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "SearchScreen") })
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){

        }
    }
}