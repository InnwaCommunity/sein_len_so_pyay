package com.example.crane.module.championsprofile

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crane.ui.theme.CraneTheme
import com.example.crane.R

@Preview(showBackground = true)
@Composable
fun AboutPagePreview() {
    CraneTheme {
        AboutPage()
    }
}
@Composable
fun AboutPage(){
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        Text(text = "Bio:",
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            color = Color(0xFF29332A))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Hey everyone! Lover of all things botanical and blooming. Based in Mandalay, Myanmar. Proud plant parent to a variety of indoor and outdoor plants.",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Location:",
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            color = Color(0xFF29332A))
        Spacer(modifier = Modifier.height(8.dp))
        Row (

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.location_icon),
                contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Mandalay, Myanmar",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF565954))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Links:",
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            color = Color(0xFF29332A))
        Spacer(modifier = Modifier.height(8.dp))
        Row (

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Maria Sans",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF3A7D44))
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.instegram),
                contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "mariasans957",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF3A7D44))
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "@mariatweets",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF3A7D44)
            )
        }
    }
}