package com.example.crane.module.championspage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.crane.R
import com.example.crane.config.RoutesName
import com.example.crane.models.ChampionsData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampionsPage(navController: NavController){
    val topChampionsData= listOf<ChampionsData>(
        ChampionsData(
            userName = "Max",
            image = R.drawable.img,
            starCount = 2858,
            range = 2
        ),
        ChampionsData(
            userName = "David",
            image = R.drawable.img_1,
            starCount = 3021,
            range = 1
        ),
        ChampionsData(
                userName = "Tiffny",
        image = R.drawable.img,
        starCount = 2500,
        range = 3
    ))
    val normalChampionsData = listOf<ChampionsData>(
        ChampionsData(
            userName = "Maria",
            image = R.drawable.img,
            starCount = 2480,
            range = 4
        ),
        ChampionsData(
            userName = "Gretchen",
            image = R.drawable.img_1,
            starCount = 2286,
            range = 5
        ),
        ChampionsData(
            userName = "You",
            image = R.drawable.img,
            starCount = 2125,
            range = 6
        ),
        ChampionsData(
            userName = "Charlie",
            image = R.drawable.img,
            starCount = 2078,
            range = 7
        ),
        ChampionsData(
            userName = "Cooper",
            image = R.drawable.img_1,
            starCount = 2047,
            range = 8
        ),
        ChampionsData(
            userName = "Kierra",
            image = R.drawable.img,
            starCount = 1994,
            range = 9
        ),
        ChampionsData(
            userName = "Jhon",
            image = R.drawable.img,
            starCount = 1990,
            range = 10
        )
    )

    Scaffold (
        topBar = { TopAppBar(
            title = { Text(text = "Planting champions")},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFDFF2E2),
            ),
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Default.ArrowBack, "")
                }
            },

            actions = {
                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = { /*TODO*/ }) {
                    Icon( Icons.Default.MoreHoriz,  null)
                }
            }) }
    ){paddingValues ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(paddingValues)
        ){
            LazyRow(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp))
                    .background(Color(0xFFDFF2E2)),
            ){
                items(topChampionsData){item ->
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
//                    Image(painter = painterResource(id = item.image),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(if (item.range == 1) 120.dp else 80.dp)
//                            .clip(CircleShape)
//                            .border(3.dp, Color.Green, CircleShape))
                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .clickable(onClick = {
                                navController.navigate(RoutesName.championsProfilePage)
                            })
                            .size(if (item.range == 1) 120.dp else 80.dp)
                            .clip(CircleShape)
                            .border(3.dp, Color.Gray, CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )
                        Card(
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFBEBEBE),
                            ),
//                            backgroundColor = Color.Gray,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(24.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center) {
                                Text(
                                    text = "2",
                                    color = Color.White
//                                    style = MaterialTheme.typography.body2
                                )
                            }
                        }
                    }
                    Text(text = item.userName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700)
                    Row (
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            modifier = Modifier.size(15.dp),
                            contentDescription = null)
                        Text(text = item.starCount.toString(),
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(if (item.range == 1) 30.dp else 20.dp))
                }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(normalChampionsData){ item ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clickable(onClick = {
                                navController.navigate(RoutesName.championsProfilePage)
                            })
                            .padding(10.dp)
                            .fillMaxWidth()
                            .height(76.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(if (item.userName == "You") Color.Red else Color(0xFFDFF2E2))){
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Row (
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(text = item.range.toString(),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W700)
                                Image(painter = painterResource(id = item.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(55.dp)
                                        .clip(CircleShape)
//                                        .border(1.dp, Color.Green, CircleShape)
                                )
                                Text(text = item.userName,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W700)
                            }
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.star),
                                    modifier = Modifier.size(15.dp),
                                    contentDescription = null)
                                Text(text = item.starCount.toString(),
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
        
    }
}
