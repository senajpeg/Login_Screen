package com.senaaksoy.login_screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.senaaksoy.login_screen.screens.HomepageScreen
import com.senaaksoy.login_screen.screens.MainScreen
import com.senaaksoy.login_screen.screens.SignInScreen
import com.senaaksoy.login_screen.screens.SignUpScreen

@Composable
fun Login_navigation(){
    val navController= rememberNavController()
    NavHost(navController =navController , startDestination =Screens.MAINSCREEN.route ) {
        composable(route = Screens.MAINSCREEN.route){
            MainScreen(navController = navController)
        }
        composable(route = Screens.SIGNINSCREEN.route){
            SignInScreen(navController = navController)
        }
        composable(route = Screens.SIGNUPSCREEN.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screens.HOMEPAGESCREEN.route){
            HomepageScreen(navController = navController)
        }
        

    }
}