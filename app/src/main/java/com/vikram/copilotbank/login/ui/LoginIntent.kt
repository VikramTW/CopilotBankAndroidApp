package com.vikram.copilotbank.login.ui

sealed class LoginIntent {

    var username: String = ""
    var password: String = ""

    data object Login : LoginIntent()
}