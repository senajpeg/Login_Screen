package com.senaaksoy.login_screen.viewModel

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.senaaksoy.login_screen.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel:ViewModel(){

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState :StateFlow<LoginUiState> =_uiState.asStateFlow()

    var inputName by mutableStateOf("")
    private set

    var inputEmail by mutableStateOf("")
        private set

    var inputPassword by mutableStateOf("")
        private set

    fun updateEmail(newEmail:String){
     inputEmail=newEmail
    upDateSignInButtonState()
    upDateSignUpButtonState()}

    fun updateName(newName:String){
        inputName=newName
    upDateSignUpButtonState()}

    fun updatePassword(newPassword:String){
        inputPassword=newPassword
    upDateSignInButtonState()
    upDateSignUpButtonState()}

    fun errorInNameFunction(name:String){
        val isErrorName=inputName.length < 3
        _uiState.update { currentState->
            currentState.copy(
                isErrorInName = isErrorName) }
        nameSupportingText()
    }

    fun errorInEmailfunction(email:String){
        val isErrorEmail=!Patterns.EMAIL_ADDRESS.matcher(email).matches()
        _uiState.update { currentState->
            currentState.copy(
                isErrorInEmail =isErrorEmail) }
        emailSupportingText()
        upDateSignInButtonState()
        upDateSignUpButtonState()

    }
    fun errorInPasswordfunction(){
        val isErrorPassword=inputPassword.length < 6
        _uiState.update { currentState->
            currentState.copy(
                isErrorInPassword = isErrorPassword
            ) }
    passwordSupportingText()
    upDateSignInButtonState()
    upDateSignUpButtonState()}

    private fun emailSupportingText(){
        _uiState.update { currentState->
            currentState.copy(
                emailSupportingText = if (currentState.isErrorInEmail) {
                    R.string.email_error
                } else {
                    null
                }) } }

   private fun passwordSupportingText(){
        _uiState.update { currentState->
            currentState.copy(
                passwordSupportingText = if (currentState.isErrorInPassword) {
                    R.string.password_error
                } else {
                    null }) } }

    private fun nameSupportingText(){
        _uiState.update {currentState->
            currentState.copy(
                nameSupportingText =if (currentState.isErrorInName) {
                    R.string.name_error
                } else {
                    null }) } }

   private fun upDateSignInButtonState(){
        _uiState.update { currentState ->
            currentState.copy(
                isContinueButtonEnabled = !currentState.isErrorInEmail &&
                        !currentState.isErrorInPassword &&
                        inputEmail.isNotBlank() &&
                        inputPassword.isNotBlank()
            )
        }
    }
    private fun upDateSignUpButtonState(){
        _uiState.update { currentState ->
            currentState.copy(
                isSignUpButtonEnabled = !currentState.isErrorInEmail &&
                        !currentState.isErrorInPassword &&
                        !currentState.isErrorInName&&
                        inputName.isNotBlank()&&
                        inputEmail.isNotBlank() &&
                        inputPassword.isNotBlank()
            )
        }
    }




















}