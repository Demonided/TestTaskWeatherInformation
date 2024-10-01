package com.example.testtaskweatherinformation.di

import com.example.testtaskweatherinformation.app.App
import com.example.testtaskweatherinformation.data.network.Endpoint
import com.example.testtaskweatherinformation.data.network.GlobalProjectApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        androidApplication() as App
    }

    single<Gson> {
        Gson()
    }

    single {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Уровень логирования: BODY, HEADER, BASIC, NONE
        }

        // Создаем OkHttpClient с настройками, например, добавляем интерсептор логирования
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Добавляем интерсептор для логирования
            .build()

        Retrofit.Builder()
            .baseUrl(Endpoint.OpenWeather.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GlobalProjectApi::class.java)
    }


}