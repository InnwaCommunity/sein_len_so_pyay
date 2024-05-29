package com.example.crane.module.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crane.R
import com.example.crane.module.championsprofile.ChampionsProfilePage
import com.example.crane.ui.theme.CraneTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotiListScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Notifications") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = { /*TODO*/ }) {
                        Icon( Icons.Default.MoreHoriz,  null)
                    }
                })
        }
    ){paddingValues ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){
            Image(
                modifier = Modifier
                    .height(156.dp)
                    .width(230.dp),
                painter = painterResource(id = R.drawable.notification_empty),
                contentDescription = null)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "No notification yet",
                fontSize = 20.sp,
                fontWeight = FontWeight.W700)
            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier
                .width(284.dp)
            ){
                Text(text = "Your notifications will appear here once you’ve received them.",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500)
            }

        }
    }
}