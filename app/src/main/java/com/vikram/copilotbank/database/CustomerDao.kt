package com.vikram.copilotbank.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM customer WHERE userId = :id")
    suspend fun getCustomerById(id: Int): Customer?
}