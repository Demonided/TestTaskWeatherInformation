package com.example.testtaskweatherinformation.di

import com.example.testtaskweatherinformation.presentation.information.InformationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        InformationViewModel(get(), get())
    }
}