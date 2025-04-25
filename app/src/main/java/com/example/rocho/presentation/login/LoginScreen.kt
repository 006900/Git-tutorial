package com.example.rocho.presentation.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rocho.ui.theme.background
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(modifier: Modifier = Modifier, auth: FirebaseAuth? = null,navigateToHome:()-> Unit) {

    var view by remember { mutableStateOf(false) }
    val iconColor = if (view) Color.DarkGray else Color.LightGray
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(modifier.fillMaxSize(), topBar = { TopBar() }) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(background)
                .padding(30.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.weight(2f))
            Text(
                text = "Email or username", modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White, fontSize = 32.sp
            )
            TextField(
                modifier = modifier.fillMaxWidth(), value = email,
                onValueChange = { email = it }, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.DarkGray,
                    focusedContainerColor = Color.White
                )
            )
            Spacer(modifier.height(30.dp))
            Text(
                text = "Password", modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White, fontSize = 32.sp
            )
            TextField(
                modifier = modifier.fillMaxWidth(), value = password,
                onValueChange = { password = it },
                trailingIcon = {
                    IconButton(onClick = { view = !view }) {
                        Icon(
                            imageVector = Icons.Default.RemoveRedEye,
                            contentDescription = null,
                            tint = iconColor
                        )
                    }
                }, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.DarkGray,
                    focusedContainerColor = Color.White
                )
            )

            Spacer(modifier.height(30.dp))
            Button(onClick = {
                auth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        navigateToHome()
                        Log.i("alan","login OK")
                    } else {
                        //error
                        Log.i("alan","login KO")
                    }
                } }) { Text("Log in") }
            TextButton(onClick = {}) { Text("Log in without password") }
            Spacer(modifier.weight(3f))
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = {}, colors = TopAppBarDefaults.topAppBarColors(background), navigationIcon = {
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
    )
}