package com.senaaksoy.login_screen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.senaaksoy.login_screen.R
import com.senaaksoy.login_screen.components.EditTextField
import com.senaaksoy.login_screen.viewModel.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senaaksoy.login_screen.components.MyButton
import com.senaaksoy.login_screen.navigation.Screens

@Composable
fun SignInScreen(navController: NavController,viewModel: LoginViewModel= viewModel()){
    val uiState by viewModel.uiState.collectAsState()
    Text(
        text = stringResource(id = R.string.sign_in),
        modifier = Modifier.padding(
            start = 32.dp,
            top = 32.dp),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF5F99B6))
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

      EditTextField(
      value = viewModel.inputEmail,
      onValueChange = {viewModel.updateEmail(it)
                      viewModel.errorInEmailfunction(it)},
      label =R.string.email ,
      keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.Email,
          imeAction = ImeAction.Next),
          supportingtext =uiState.emailSupportingText )

      EditTextField(value = viewModel.inputPassword,
        onValueChange = {viewModel.updatePassword(it)
                        viewModel.errorInPasswordfunction()},
        label = R.string.password,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done),
        supportingtext = uiState.passwordSupportingText)

      MyButton(
          text = R.string.Continue,
          isEnabled = uiState.isContinueButtonEnabled,
          onClickAction = { navController.navigate(Screens.HOMEPAGESCREEN.route)},) } }