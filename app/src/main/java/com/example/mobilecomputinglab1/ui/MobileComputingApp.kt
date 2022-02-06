package com.example.mobilecomputinglab1.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilecomputinglab1.MobileComputingAppState
import com.example.mobilecomputinglab1.rememberMobileComputingAppState
import com.example.mobilecomputinglab1.ui.Home.Home
import com.example.mobilecomputinglab1.ui.Login.Login
import com.example.mobilecomputinglab1.ui.Login.Signup


@Composable

fun MobileComputingApp(
    appState : MobileComputingAppState = rememberMobileComputingAppState()

){
   NavHost(
       navController = appState.navController, startDestination = "Login"
   ){
       composable(route="Login"){
//           Login(navController = appState.navController)
//           val loginActivity = LoginActivity()
//           loginActivity.Login(navController = appState.navController)

           Login(navController = appState.navController)

       }
           composable(route = "home") {
               Home(
                   navController = appState.navController
               )
           }
           composable(route = "signup") {
               Signup(
                   navController = appState.navController
               )
           }
       }
   }

