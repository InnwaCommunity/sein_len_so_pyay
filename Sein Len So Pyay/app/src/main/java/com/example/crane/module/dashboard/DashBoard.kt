package com.example.crane.module.dashboard

import com.example.crane.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){
    var showDialog by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    var otpValue by remember {
        mutableStateOf("")
    }

    if (showDialog){
        CustomDialog(onDismiss = { showDialog = false })
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Jetpack Compose UI Sample") })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val image: Painter = painterResource(id = R.drawable.icons) // replace with your image resource
                Image(painter = image, contentDescription = null, modifier = Modifier.size(128.dp))

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    label = { Text("Input Text") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { showDialog = true }) {
                    Text("Show Dialog")
                }
                OtpTextField(
                    otpText = otpValue,
                    onOtpTextChange = { value, otpInputFilled ->
                        otpValue = value
                    }
                )
            }
        }
    )
}


@Composable
fun CustomDialog(onDismiss: () -> Unit){
    Dialog(onDismissRequest = onDismiss) {
        Surface (
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ){
            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "This is a dialog")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onDismiss) {
                    Text(text = "Dismiss")
                }
            }
        }
    }
}