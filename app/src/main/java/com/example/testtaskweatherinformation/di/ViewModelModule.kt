package com.example.testtaskweatherinformation.di

import com.example.testtaskweatherinformation.presentation.information.InformationWeatherViewModel
import com.example.testtaskweatherinformation.presentation.listniformationweather.ListInformationWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        InformationWeatherViewModel(get(), get())
    }

    viewModel {
        ListInformationWeatherViewModel(get())
    }
}