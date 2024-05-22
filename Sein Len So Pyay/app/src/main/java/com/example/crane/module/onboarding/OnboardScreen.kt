package com.example.crane.module.onboarding

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crane.models.OnboardPage
import com.example.crane.Tags
import com.example.crane.config.RoutesName
import com.example.crane.config.SharedPref
import com.example.crane.onboardPageList


@Composable
fun OnboardScreen(navController: NavController){
    val onboardPages = onboardPageList
    val context = LocalContext.current

    val currentPage = remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(Tags.TAG_ONBOARD_SCREEN)
    ) {
        OnBoardImageView(
            modifier = Modifier
                .weight(1f)
                .padding(37.dp)
                .fillMaxWidth(),
            currentPage = onboardPages[currentPage.value]
        )
        OnBoardingTones(
            allPages= onboardPages.size,
            currentIndex = currentPage.value
        )
        OnBoardDetails(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            currentPage = onboardPages[currentPage.value]
        )
        OnBoardNavButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            currentPage = currentPage.value,
            noOfPages = onboardPages.size,
            onSkipClicked = {

                setFirstTime(context)
                navController.navigate(RoutesName.login){
                    popUpTo(navController.graph.startDestinationId){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            onNextClicked = {
                if (currentPage.value >= onboardPages.size - 1){
                    setFirstTime(context)
                    navController.navigate(RoutesName.login){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                } else {
                    currentPage.value++
                }
            }
        )
    }
}

@Composable
fun OnBoardImageView(modifier: Modifier = Modifier, currentPage: OnboardPage){
    val imageRes = currentPage.imageRes

    Box(modifier = modifier.
    testTag(Tags.TAG_ONBOARD_SCREEN_IMAGE_VIEW + currentPage.title)){
        Image(painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth)
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.BottomCenter)
            .graphicsLayer {
                alpha = 0.6f
            }
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        Pair(0.8f, Color.Transparent), Pair(1f, Color.White)
                    )
                )
            ))
    }

}


@Composable

fun OnBoardingTones(allPages: Int,currentIndex: Int){



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(allPages) { index ->
                val color = if (currentIndex == index) Color(0xFF3A7D44) else Color(0xFFD3D3D3)
                val width = if (currentIndex == index) 24.dp else 8.dp
                val height = 8.dp
                val shape = RoundedCornerShape(percent = 50)
                Box(
                    modifier = Modifier
                        .width(width)
                        .height(height)
                        .background(color = color, shape = shape)
                )
            }
        }
    }
}
@Composable
fun OnBoardDetails(modifier: Modifier = Modifier, currentPage: OnboardPage){
    Column(
        modifier = modifier
    ) {
        Text(text = currentPage.title,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            color = Color(0xFF3A7D44),
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = currentPage.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color(0xFF181D27),
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun OnBoardNavButton(
    modifier: Modifier = Modifier,
    currentPage: Int,
    noOfPages: Int,
    onNextClicked: () -> Unit,
    onSkipClicked: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier // Use the passed modifier here
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = { onNextClicked() }, // Invoke the lambda
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3A7D44) // Green color
            ),
            shape = RoundedCornerShape(50), // Rounded corner with a high radius
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Text(
                text = if (currentPage < noOfPages - 1) "Continue" else "Get Started",
                color = Color.White,
                fontSize = 16.sp
            )
        }
        TextButton(onClick = { onSkipClicked() }) {
            Text(
                text = "Skip",
                color = Color(0xFF181D27),
                fontSize = 16.sp
            )
        }
    }
}

private fun setFirstTime(context: Context){
    SharedPref.setBoolean(context,true,SharedPref.FIRSTTIME)
}

@Composable
fun TabSelector(onboardPages: List<OnboardPage>, currentPage: Int, onTabSelected: (Int) -> Unit){
    TabRow(selectedTabIndex = currentPage,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .testTag(Tags.TAG_ONBOARD_TAG_ROW)) {
        onboardPages.forEachIndexed { index, _ ->
            Tab(selected = index == currentPage, onClick = {
                onTabSelected(index)
            },
                modifier = Modifier.padding(16.dp), content = {
                    Box(modifier = Modifier
                        .testTag("${Tags.TAG_ONBOARD_TAG_ROW}$index")
                        .size(8.dp)
                        .background(
                            color = if (index == currentPage) MaterialTheme.colorScheme.onPrimary
                            else Color.LightGray, shape = RoundedCornerShape(4.dp)
                        ))
                })
        }
    }
}