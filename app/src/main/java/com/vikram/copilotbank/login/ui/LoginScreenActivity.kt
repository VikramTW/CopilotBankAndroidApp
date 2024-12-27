package com.vikram.copilotbank.login.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.vikram.copilotbank.R
import com.vikram.copilotbank.MainActivity
import com.vikram.copilotbank.widgets.Loader
import com.vikram.copilotbank.widgets.PrimaryButton
import com.vikram.copilotbank.widgets.RoundedTextField
import com.vikram.copilotbank.widgets.SecondaryButton
import dagger.hilt.android.AndroidEntryPoint


// create a new AppCompatActivity called LoginScreenActivity in the login.ui package
// create composable function LoginScreen and set UI for LoginScreenActivity
// LoginScreen should have two text fields for the user to enter their email and password, and a button to submit the form.
// You can use the following code as a starting point:
// column which contains app logo, app name, email and password fields and login button

@AndroidEntryPoint
class LoginScreenActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val state by loginViewModel.loginState.collectAsState()
            when {
                state.isLoading -> {
                    Loader()
                }
                state.success -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                state.error.isNotEmpty() -> {
                    Toast.makeText(
                        context,
                        "Invalid credentials",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            LoginScreen()
        }
    }


    @Composable
    fun LoginScreen() {
        var email by remember { mutableStateOf("1234") }
        var password by remember { mutableStateOf("4321") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Logo",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "CoPilot Bank",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(32.dp))

            RoundedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Customer Id") },
                placeholder = { Text("Enter Customer Id") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            RoundedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                PrimaryButton(
                    text = "Login",
                    onClick = {
                        val loginIntent = LoginIntent.Login
                        loginIntent.username = email
                        loginIntent.password = password
                        loginViewModel.handleIntent(loginIntent)
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                SecondaryButton(
                    text = "Register",
                    onClick = {

                              },
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}

