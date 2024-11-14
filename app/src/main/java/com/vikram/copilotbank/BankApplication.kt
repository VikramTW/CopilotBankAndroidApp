package com.vikram.copilotbank

import android.app.Application
import com.vikram.copilotbank.database.BankDatabase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BankApplication : Application() {

    lateinit var bankDatabase: BankDatabase

    override fun onCreate() {
        super.onCreate()

    }
}
