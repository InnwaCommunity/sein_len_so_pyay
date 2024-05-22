package com.example.crane.module.loginpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crane.R
import com.example.crane.config.RoutesName

@Composable
fun LoginScreen(navController: NavController){
    val scrollState = rememberScrollState()
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    Text(text = "Log in", fontSize = 24.sp,
                        fontWeight = FontWeight.W500)
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(onClick = { /*TODO*/ }
                        ) {
                            Text(text = "forget password",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500)
                        }
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
                            text = "Log In",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    OrDivider()
                    Text(text = "Continue with",
                        fontSize = 16.sp,
                        color = Color(0xFF364D39),
                        fontWeight = FontWeight.W500
                    )
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
                    Text(text = "Don’t you have an account?",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )
                    TextButton(onClick = {
                        navController.navigate(RoutesName.signup)
                    }) {
                        Text(text = "Sign up",
                            fontSize = 16.sp,
                            color = Color(0xFF3A7D44))
                    }
                }
            }
        }
    )
}


@Composable
fun OrDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape)
                .height(1.dp)
        )
        Text(
            text = "Or",
            fontSize = 14.sp,
            color = Color(0xFF70736D),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider(
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape)
                .height(1.dp)
        )
    }
}


@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
//        label = { Text(text = "Email Address") },
        placeholder = { Text(text = "Enter your email") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
fun PasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
//        label = { Text(text = "Password") },
        placeholder = { Text(text = "Password") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "Password Icon")
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    )
}