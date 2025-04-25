package com.example.rocho.presentation.initial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rocho.R
import com.example.rocho.ui.theme.Btc_singUp
import com.example.rocho.ui.theme.background

@Preview
@Composable
fun InitialScreen(modifier: Modifier = Modifier,navigateToLogin:()-> Unit ={},navigateToSignUp: () -> Unit={}) {
    Column (
        modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier.weight(1.5f))

        Image(painter = painterResource(id = R.drawable.spotify_128),contentDescription = null)

        Spacer(modifier.weight(1.5f))

        Text(text = "Millions of songs.", fontSize = 34.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = "Free on Spotify", fontSize = 34.sp, color = Color.White, fontWeight = FontWeight.Bold)

        Spacer(modifier.weight(1f))

        Button(
            modifier = modifier.fillMaxWidth(0.90f),
            onClick = {navigateToSignUp()},
            colors = ButtonDefaults.buttonColors(Btc_singUp)) {
            Text(text = "Sign up Free")
        }

        Spacer(modifier.weight(0.10f))

        Button(
            modifier = modifier.fillMaxWidth(0.90f),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(width = 1.dp, color = Color.DarkGray),
            onClick = {}) {
            Text(text = "Continue with Facebook")
        }

        Spacer(modifier.weight(0.10f))

        Button(
            modifier = modifier.fillMaxWidth(0.90f),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(width = 1.dp, color = Color.DarkGray),
            onClick = {}) {
            Text(text = "Continue with Google")
        }

        Spacer(modifier.weight(0.50f))

        TextButton(onClick = {navigateToLogin()}) {
            Text(text = "Log in", color = Color.White)
        }

        Spacer(modifier.weight(0.50f))
    }
}
