package com.example.crane.module.splashscreen
import com.example.crane.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crane.config.SharedPref
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        delay(3000)
        if (SharedPref.getBoolean(
                context = context,
                key = SharedPref.FIRSTTIME
            ) == null) {
            SharedPref.setBoolean(
                context = context,
                value = false,
                key = SharedPref.FIRSTTIME
            )
            navController.navigate("onboard") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            navController.navigate("dashboard") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "Splash Logo",
            modifier = Modifier
                .width(235.63.dp)
                .height(130.dp))
    }
}