package com.vikram.copilotbank.login.data.repository

import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRepository @Inject constructor() {

    // private lateinit var database: BankDatabase

    suspend fun login(username: String, password: String): Boolean {
        delay(2000)
        // val customer = database.customerDao().getCustomerById(username.toInt())
        if(!((username == "1234") && (password == "4321"))) {
            throw Exception("Invalid credentials")
        }
        return true
    }
}