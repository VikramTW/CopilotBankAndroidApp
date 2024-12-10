package com.vikram.copilotbank.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikram.copilotbank.login.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun handleIntent (intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Login -> {
                login(intent.username, intent.password)
            }
        }
    }

    private fun login(username: String, password: String) {
        _loginState.value = _loginState.value.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val success = loginRepository.login(username, password)
                _loginState.value = _loginState.value.copy(isLoading = false, success = success, error = "")
            } catch (e: Exception) {
                _loginState.value = _loginState.value.copy(isLoading = false, error = e.message ?: "", success = false)
            }
        }
    }
}