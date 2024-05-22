package com.example.crane.module.otpverify

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crane.config.RoutesName
import com.example.crane.module.dashboard.OtpTextField
import com.example.crane.module.signup.SignUpScreen

@Preview
@Composable
fun PreviewMyApp() {
    val navController = rememberNavController()
    OtpVerifyPage(navController)
}

@Composable
fun OtpVerifyPage(navController: NavController){
    var otpValue by remember {
        mutableStateOf("")
    }
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
               Column (
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Top
               ){
                   Spacer(modifier = Modifier.height(80.dp))
                   Box (
                       contentAlignment= Alignment.Center,
                       modifier = Modifier
                           .width(197.dp)
                   ){
                       Column (
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.Center
                       ){
                           Text(text = "Verify Account",
                               fontSize = 24.sp,
                               color = Color(0xFF181D27),
                               fontWeight = FontWeight.W700)
                           Text(
                               text = "Enter the OTP sent to sample276@gmail.com",
                               fontSize = 16.sp,
                               color = Color(0xFF364D39),
                               fontWeight = FontWeight.W500,
                               textAlign = TextAlign.Center,  // Correct property for text alignment
                               modifier = Modifier.fillMaxWidth()  // Ensures the text takes the full width for centering
                           )

                           Spacer(modifier = Modifier.height(46.dp))
                       }
                   }

                   OtpTextField(
                       otpText = otpValue,
                       otpCount = 4,
                       onOtpTextChange = { value, otpInputFilled ->
                           otpValue = value
                       }
                   )
                   Spacer(modifier = Modifier.height(46.dp))
                   Text(text = "01:20",
                       fontWeight = FontWeight.W500,
                       color = Color(0xFF3A7D44),
                       fontSize = 16.sp)
                   Row (
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ){
                       Text(text = "Don’t receive code?")
                       TextButton(onClick = { /*TODO*/ }) {
                           Text(text = "Resend")
                       }
                   }
               }
                Column {
                    Button(
                        onClick = {
                            navController.navigate(RoutesName.dashboard)
                        }, // Invoke the lambda
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3A7D44) // Green color
                        ),
                        shape = RoundedCornerShape(50), // Rounded corner with a high radius
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.dp)
                    ) {
                        Text(
                            text = "Verify",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(46.dp))
                }
            }})
}