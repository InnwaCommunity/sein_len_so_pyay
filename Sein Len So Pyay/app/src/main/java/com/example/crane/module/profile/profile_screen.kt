package com.example.crane.module.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
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
import com.example.crane.Greeting
import com.example.crane.R
import com.example.crane.config.RoutesName
import com.example.crane.module.championsprofile.AboutPage
import com.example.crane.module.championsprofile.BadgesPage
import com.example.crane.module.championsprofile.PostsPage
import com.example.crane.module.home.HomeCategoryTabIndicator
import com.example.crane.module.home.MyTab
import com.example.crane.ui.theme.CraneTheme


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    CraneTheme {
        ProfileScreen(navController)
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileScreen(navController: NavController){
    val scrollState = rememberScrollState()

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
                        modifier = Modifier.size(32.dp)
                            .padding(end = 10.dp),
                        onClick = {
                            navController.navigate(RoutesName.createnew)
                        }) {
                        Icon( Icons.Default.Add,  null)
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
                        Text(text = "Ranking-6",
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
                        Text(text = "2125",
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
            Text(text = "Michael Wong",
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
                color = Color(0xFF181D27))
            Spacer(modifier = Modifier.height(10.dp))
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
            Spacer(modifier = Modifier.height(10.dp))

            Column() {
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
