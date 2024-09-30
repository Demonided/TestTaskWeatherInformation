package com.example.testtaskweatherinformation.di

import com.example.testtaskweatherinformation.presentation.information.InformationWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        InformationWeatherViewModel(get(), get())
    }
}