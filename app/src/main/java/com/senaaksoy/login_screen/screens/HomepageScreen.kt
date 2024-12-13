package com.senaaksoy.login_screen.screens

import android.app.AlertDialog
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaaksoy.login_screen.R
import com.senaaksoy.login_screen.components.MyButton
import com.senaaksoy.login_screen.navigation.Screens

@Composable
fun HomepageScreen(navController: NavController){
    val context = LocalContext.current
    BackHandler {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(R.string.logOut_message)
        alertDialog.setMessage(R.string.alert_setMessage)
        alertDialog.setPositiveButton(R.string.yes) { _, _ ->
            navController.navigate(Screens.MAINSCREEN.route)
        }
        alertDialog.setNegativeButton(R.string.no, null)
        alertDialog.show()
    }

    Text(
        text = stringResource(id = R.string.log_out),
        modifier = Modifier.padding(
            start = 32.dp,
            top = 32.dp),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF5F99B6)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.login) ,
            contentDescription =null,
            modifier = Modifier.padding(48.dp))
        MyButton(
            text =R.string.log_out ,
            onClickAction = {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle(R.string.logOut_message)
                alertDialog.setMessage(R.string.alert_setMessage)
                alertDialog.setPositiveButton(R.string.yes) { _, _ ->
                    navController.navigate(Screens.MAINSCREEN.route)
                }
                alertDialog.setNegativeButton(R.string.no, null)
                alertDialog.show()

            })

    }
}