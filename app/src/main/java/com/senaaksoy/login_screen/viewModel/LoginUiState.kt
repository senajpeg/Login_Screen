package com.senaaksoy.login_screen.viewModel

        data class LoginUiState(
          val isErrorInPassword:Boolean=false,
          val isErrorInEmail :Boolean=false,
          val isErrorInName: Boolean=false,
          val emailSupportingText: Int?=null,
          val passwordSupportingText:Int?=null,
          val nameSupportingText:Int?=null,
          val isContinueButtonEnabled: Boolean=false,
          val isSignUpButtonEnabled : Boolean=false)