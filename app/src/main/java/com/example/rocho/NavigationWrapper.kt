package com.example.rocho

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rocho.presentation.home.HomeScreen
import com.example.rocho.presentation.initial.InitialScreen
import com.example.rocho.presentation.login.LoginScreen
import com.example.rocho.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun NavigationWrapper(
    navHostController: NavHostController,
    auth: FirebaseAuth,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navHostController, startDestination = "homeScreen") {
        composable("initialScreen"){
            InitialScreen(
                navigateToLogin = {navHostController.navigate("loginScreen")},
                navigateToSignUp = {navHostController.navigate("signUpScreen")}
            )
        }
        composable("loginScreen"){
            LoginScreen(auth = auth){
                navHostController.navigate("homeScreen")
            }
        }
        composable("signUpScreen"){
            SignUpScreen(auth = auth)
        }
        composable ("homeScreen"){
            HomeScreen()
        }
    }
}
