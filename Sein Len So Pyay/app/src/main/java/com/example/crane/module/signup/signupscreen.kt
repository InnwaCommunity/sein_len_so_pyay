package com.example.crane.module.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crane.R
import com.example.crane.config.RoutesName
import com.example.crane.module.loginpage.EmailTextField
import com.example.crane.module.loginpage.OrDivider
import com.example.crane.module.loginpage.PasswordTextField


@Composable
fun SignUpScreen(navController: NavController){
    val scrollState = rememberScrollState()
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var checkStatus by remember { mutableStateOf(false) }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ){
                        Box (
                            modifier = Modifier
                                .weight(1f)
                        ){}
                        Text(text = "Sign Up", fontSize = 24.sp,
                            fontWeight = FontWeight.W500)
                        Box (
                            modifier = Modifier
                                .weight(1f)
                        ){}
                    }
                    Column (
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(text = "Email Address",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),)
                        EmailTextField(value = email, onValueChange = { email = it })
                        Text(text = "Password",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),)
                        PasswordTextField(value = password, onValueChange = { password = it })
                    }
                    Row (
                        horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                    ){
                        Checkbox(checked = checkStatus, onCheckedChange = { checkStatus = it })
                        Text(text = "I accept terms and conditions!",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
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
                            text = "Sign Up",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    OrDivider()
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ){
                        Box (
                            modifier = Modifier
                                .weight(1f)
                        ){}
                        Text(text = "Continue with",
                            fontSize = 16.sp,
                            color = Color(0xFF364D39),
                            fontWeight = FontWeight.W500
                        )
                        Box (
                            modifier = Modifier
                                .weight(1f)
                        ){}
                    }
                    Row (
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ){
                        Image(painter = painterResource(R.drawable.facebook_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                                .padding(10.dp))
                        Image(painter = painterResource(R.drawable.instegram),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                                .padding(10.dp))
                        Image(painter = painterResource(R.drawable.twitter),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                                .padding(10.dp))
                    }
                }
                Row (
                    modifier = Modifier
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement=Arrangement.Absolute.Center
                ){
                    Text(text = "Already have an account?",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )
                    TextButton(onClick = {
                        navController.navigate(RoutesName.login)
                    }) {
                        Text(text = "Log In",
                            fontSize = 16.sp,
                            color = Color(0xFF3A7D44))
                    }
                }
            }})
}