package com.example.crane.module.championsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crane.R
import com.example.crane.models.BadgeData
import com.example.crane.models.PostData
import com.example.crane.ui.theme.CraneTheme

//
@Composable
fun BadgesPage(navController: NavController){
    val plants = remember {
        listOf(
            BadgeData(R.drawable.nature_hero, "Nature Hero"),
            BadgeData(R.drawable.tree_lover, "Tree Lover"),
            BadgeData(R.drawable.plant_pro, "Plant Pro"),
            BadgeData(R.drawable.tree_trooper, "Tree Trooper")
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
        .fillMaxSize()
    ) {
        items(plants.size) {item ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(162.dp)
                    .padding(3.dp)
                    .background(Color(0xFFF4F7F2))
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = plants[item].postUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .height(127.dp)
                            .width(90.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = plants[item].reactCount,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        color = Color(0xFF29332A))
                    
                }
            }
        }
    }
}

