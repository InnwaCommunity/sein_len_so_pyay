package com.example.crane.module.championsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.crane.ui.theme.CraneTheme
import com.example.crane.R
import com.example.crane.module.home.HomeCategoryTabIndicator
import com.example.crane.module.home.MyTab


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ChampionsProfilePage(navController: NavController){

    var tabIndex by remember { mutableIntStateOf(0) }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        HomeCategoryTabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
            color = Color.Black,
        )
    }
    val tabs = listOf("Posts", "Badges","About")
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Maria") },
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
    ){ paddingValues ->  
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Box (
                    modifier = Modifier
                        .height(42.dp)
                        .width(100.dp)
                        .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .background(Color(0xFFF4F7F2))
                ){
                    Row (
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(painter = painterResource(id = R.drawable.img_4),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp))
                        Text(text = "Ranking-4",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500)
                    }
                }
                Box (
                    modifier = Modifier
                        .height(42.dp)
                        .width(100.dp)
                        .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .background(Color(0xFFF4F7F2))
                ){
                    Row (
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp))
                        Text(text = "2480",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500)
                    }
                }
            }
            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )
            Text(text = "Maria",
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
                color = Color(0xFF181D27))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ){
                    Text(text = "853",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF181D27))
                    Text(text = "Followers",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF565954))
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ){
                    Text(text = "58",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF181D27))
                    Text(text = "Following",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = Color(0xFF565954))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3A7D44) // Green color
                    ),
                    shape = RoundedCornerShape(50), // Rounded corner with a high radius
                    modifier = Modifier
                        .height(35.dp)
                        .width(162.dp)
                        .padding(horizontal = 5.dp)) {
                    Text(text = "Follow",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFFFAFCF7))
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF70736D) // Green color
                    ),
                    shape = RoundedCornerShape(50), // Rounded corner with a high radius
                    modifier = Modifier
                        .height(35.dp)
                        .width(162.dp)
                        .padding(horizontal = 5.dp)) {
                    Text(text = "Appreciate",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Color(0xFFFAFCF7))
                }
            }

            Column(modifier = Modifier.padding(paddingValues)) {
                ScrollableTabRow(
                    edgePadding = 0.dp,
                    selectedTabIndex = tabIndex,
                    indicator = indicator,
                    divider = @Composable {
                        Divider(
                            color = Color.White
                        )
                    }
                ) {
                    tabs.forEachIndexed { index,title ->
                        MyTab(
                            onClick = {
                                tabIndex = index
                            },
                            title = title
                        )
                    }
                }
                when (tabIndex) {
                    0 -> PostsPage(navController)
                    1 -> BadgesPage(navController)
                    2 -> AboutPage()
                }
            }
        }
    }
}
