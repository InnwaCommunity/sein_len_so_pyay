package com.example.crane.module.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import com.example.crane.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crane.config.RoutesName
import com.example.crane.ui.theme.CraneTheme



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    CraneTheme {
        HomeScreen(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
//    val navhomeController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = {
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(23.dp),
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo")
                },
                        actions = {
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                IconButton(onClick = {
//                                    navController.safeNavigate(RoutesName.championsPage)
                                    navController.navigate(RoutesName.championsPage)
                                }) {
                                    Icon(
                                        modifier = Modifier
                                            .width(28.dp)
                                            .background(Color(0xFFF4F7F2))
                                            .height(28.dp),
                                        painter = painterResource(id = R.drawable.prize),
                                        contentDescription = "Prize")
                                }
                                Spacer(modifier = Modifier.width(7.dp))
                                Row (
                                    modifier = Modifier
                                        .padding(1.dp)
                                        .background(Color(0xFFF4F7F2))
                                ){
                                    Icon(
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp),
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = "Star")
                                    Text(text = "2125",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color(0xFF29332A)
                                    )
                                }
                                Spacer(modifier = Modifier.width(7.dp))
                                IconButton(onClick = {
                                    navController.navigate(RoutesName.notificationListPage)
                                }) {
                                    Icon(
                                        modifier = Modifier
                                            .width(18.dp)
                                            .height(18.dp),
                                        painter = painterResource(id = R.drawable.notification),
                                        contentDescription = "notification")
                                }
                            }
                        }
                )
            }

        ) {paddingValues ->
//            val selectedIndex = categories.indexOfFirst { it == selectedCategory }

            var tabIndex by remember { mutableIntStateOf(0) }

            val indicator = @Composable { tabPositions: List<TabPosition> ->
                HomeCategoryTabIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = Color.Black,
                )
            }
            val tabs = listOf("Discover", "Following")

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
                    0 -> DiscoverPage(navController)
                    1 -> DiscoverPage(navController)
                }
            }
        }
}



@Composable
fun MyTab(
    onClick: (String) -> Unit,
    title: String
) {
    Column(
        Modifier
            .padding(10.dp)
            .wrapContentHeight()
            .wrapContentWidth()
            .clickable { onClick(title) },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
//            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun HomeCategoryTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Blue
) {
    Spacer(
        modifier
            .padding(horizontal = 10.dp)
            .height(4.dp)
            .background(color, RoundedCornerShape(topStartPercent = 100, topEndPercent = 100))
    )
}
