package com.example.crane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crane.config.RoutesName
import com.example.crane.module.loginpage.LoginScreen
import com.example.crane.models.OnboardPage
import com.example.crane.module.championspage.ChampionsPage
import com.example.crane.module.championsprofile.ChampionsProfilePage
import com.example.crane.module.createpage.CreateNew
import com.example.crane.module.dashboard.DashboardScreen
import com.example.crane.module.home.HomeScreen
import com.example.crane.module.notification.NotiListScreen
import com.example.crane.module.onboarding.OnboardScreen
import com.example.crane.module.plants.PlantScreen
import com.example.crane.module.profile.ProfileScreen
import com.example.crane.module.search.SearchScreen
import com.example.crane.module.splashscreen.SplashScreen
import com.example.crane.module.signup.SignUpScreen
import com.example.crane.ui.theme.CraneTheme

val onboardPageList= listOf(
    OnboardPage(
        imageRes = R.drawable.onboarding1,
        title = "Join the Green Movement",
        description = "Plant trees, share your journey, inspire change. Join thousands in creating a greener world."
    ),
    OnboardPage(
        imageRes = R.drawable.onboarding2,
        title = "Capture Your Tree-Planting Journey",
        description = "Document your tree planting. Snap, select, share and make every tree count."
    ),
    OnboardPage(
        imageRes = R.drawable.onboarding3,
        title = "Earn Badges and Recognition",
        description = "Earn badges as you plant grow. Showcase your contribution to the environment."
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

    NavHost(navController = navController, startDestination = RoutesName.splash) {
        composable(RoutesName.splash) { SplashScreen(navController) }
        composable(RoutesName.onboard) { OnboardScreen(navController) }
        composable(RoutesName.login){ LoginScreen(navController) }
        composable(RoutesName.signup){ SignUpScreen(navController) }
        composable(RoutesName.dashboard) { DashboardScreen(navController) }
        composable(RoutesName.championsPage){ ChampionsPage(navController)}
        composable(RoutesName.championsProfilePage){ ChampionsProfilePage(navController)}
        composable(RoutesName.notificationListPage){ NotiListScreen(navController) }
        composable(RoutesName.createnew){ CreateNew(navController)}
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