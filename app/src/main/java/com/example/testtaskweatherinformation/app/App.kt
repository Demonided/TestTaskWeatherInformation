package com.example.testtaskweatherinformation.app

import android.app.Application
import com.example.testtaskweatherinformation.di.dataModule
import com.example.testtaskweatherinformation.di.dbModule
import com.example.testtaskweatherinformation.di.repositoryModule
import com.example.testtaskweatherinformation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                dbModule,
                viewModelModule,
                repositoryModule
            )
        }
    }
}