package com.example.testtaskweatherinformation.di

import com.example.testtaskweatherinformation.data.information.WeatherRepositoryImpl
import com.example.testtaskweatherinformation.domain.information.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }
}