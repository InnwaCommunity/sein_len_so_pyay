package com.example.crane.module.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crane.models.OnboardPage
import com.example.crane.Tags
import com.example.crane.onboardPageList


@Composable
fun OnboardScreen(navController: NavController){
    val onboardPages = onboardPageList

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
                .fillMaxWidth(),
            currentPage = onboardPages[currentPage.value]
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
            noOfPages = onboardPages.size
        ){
            if (currentPage.value >= onboardPages.size - 1){
                navController.navigate("dashboard"){
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
fun OnBoardDetails(modifier: Modifier = Modifier, currentPage: OnboardPage){
    Column(
        modifier = modifier
    ) {
        Text(text = currentPage.title,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = currentPage.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun OnBoardNavButton(
    modifier: Modifier = Modifier, currentPage: Int, noOfPages: Int, onNextClicked: () -> Unit
){
    Button(onClick = {
        onNextClicked()
    },
        modifier = modifier.testTag(Tags.TAG_ONBOARD_SCREEN_NAV_BUTTON)) {
        Text(text = if (currentPage < noOfPages - 1) "Next" else "Get Started")
    }
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