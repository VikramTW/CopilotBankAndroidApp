package com.vikram.copilotbank.login.ui

import com.vikram.copilotbank.login.data.domain.User

data class LoginState(
    var isLoading: Boolean = false,
    var error: String = "",
    var success: Boolean = false,
    var user: User? = null
)