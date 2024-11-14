package com.vikram.copilotbank.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [Customer::class], version = 1)
abstract class BankDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile
        private var INSTANCE: BankDatabase? = null

        fun getDatabase(context: Context): BankDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BankDatabase::class.java,
                    "bankdatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}