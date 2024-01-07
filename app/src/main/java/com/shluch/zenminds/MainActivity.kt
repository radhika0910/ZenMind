package com.shluch.zenminds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.HomePage
import screens.SignUpScreen

class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }

        setContent {
            val navController = rememberNavController()
            ZenMind(navController)
        }
    }
}

@Composable
fun ZenMind(navController: NavHostController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SignUpScreen") {
        composable("SignUpScreen") {
            SignUpScreen {  navController.navigate("LoginPage") }
        }
    }
}