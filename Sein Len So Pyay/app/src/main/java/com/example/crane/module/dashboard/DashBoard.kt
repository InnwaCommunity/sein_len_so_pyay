package com.example.crane.module.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crane.module.home.HomeScreen
import com.example.crane.R
import com.example.crane.config.RoutesName
import com.example.crane.module.plants.PlantScreen
import com.example.crane.module.profile.ProfileScreen
import com.example.crane.module.search.SearchScreen
import com.example.crane.ui.theme.CraneTheme


@Preview(showBackground = true)
@Composable
fun DiscoverPagePreview() {
    val navController = rememberNavController()
    CraneTheme {
        DashboardScreen()
    }
}
@Composable
fun DashboardScreen() {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed {index,navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        icon = {
                            Column {
                                Icon(
                                    painter = painterResource(id = navigationItem.icon),
                                    modifier = Modifier.size(32.dp),
                                    tint = if (index == navigationSelectedItem) Color.Green else Color.Black,
//                                navigationItem.icon,
                                    contentDescription = navigationItem.label
                                )
                                if (index == navigationSelectedItem) Spacer(modifier = Modifier.height(30.dp)) else Spacer(modifier = Modifier.height(0.dp))
                            }
                        },
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = RoutesName.home,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(RoutesName.home) {
                HomeScreen(
                    navController
                )
            }
            composable(RoutesName.search) {
                SearchScreen(
                    navController
                )
            }
            composable(RoutesName.plants) {
                PlantScreen(
                    navController
                )
            }
            composable(RoutesName.profile) {
                ProfileScreen(
                    navController
                )
            }
        }
    }
}
//initializing the data class with default parameters
data class BottomNavigationItem(
    val label : String = "",
    val icon: Int = R.drawable.home_icon,
    val route : String = ""
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = R.drawable.home_icon,
                route = RoutesName.home
            ),
            BottomNavigationItem(
                label = "Search",
                icon = R.drawable.search_icon,
                route = RoutesName.search
            ),
            BottomNavigationItem(
                label = "Plants",
                icon = R.drawable.plant_icon,
                route = RoutesName.plants
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = R.drawable.person_icon,
                route = RoutesName.profile
            ),
        )
    }
}


