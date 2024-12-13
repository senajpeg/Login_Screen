package com.senaaksoy.login_screen.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senaaksoy.login_screen.R
import com.senaaksoy.login_screen.components.MyButton
import com.senaaksoy.login_screen.navigation.Screens

@Composable
fun MainScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
            .fillMaxSize()) {
        BackHandler {}
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription =null,
            modifier = Modifier.padding(48.dp))
        MyButton(
            text = R.string.sign_in,
            onClickAction = {navController.navigate(Screens.SIGNINSCREEN.route)  }
        )
        MyButton(
            text = R.string.sign_up,
            onClickAction = { navController.navigate(Screens.SIGNUPSCREEN.route)})
    }
}
