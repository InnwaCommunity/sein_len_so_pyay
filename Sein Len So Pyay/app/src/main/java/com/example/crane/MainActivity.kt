package com.example.crane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crane.models.OnboardPage
import com.example.crane.module.dashboard.DashboardScreen
import com.example.crane.module.onboarding.OnboardScreen
import com.example.crane.module.splashscreen.SplashScreen
import com.example.crane.ui.theme.CraneTheme

val onboardPageList= listOf(
    OnboardPage(
        imageRes = R.drawable.second_gear,
        title = "Second Gear",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    ),
    OnboardPage(
        imageRes = R.drawable.third_gear,
        title = "Third Gear",
        description = "Praesent at semper est, nec consectetur justo."
    ),
    OnboardPage(
        imageRes = R.drawable.gear_four,
        title = "Gear four",
        description = "In auctor ultrices turpis at blandit."
    )
)
object Tags {
    const val TAG_ONBOARD_SCREEN = "onboard_screen"
    const val TAG_ONBOARD_SCREEN_IMAGE_VIEW = "onboard_screen_image"
    const val TAG_ONBOARD_SCREEN_NAV_BUTTON = "nav_button"
    const val TAG_ONBOARD_TAG_ROW = "tag_row"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CraneTheme {
                MainScreen()
            }
        }
    }
}
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("onboard") { OnboardScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CraneTheme {
        Greeting("Android")
    }
}