package com.vikram.copilotbank.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val userName: String,
    val email: String,
    val password: String
)