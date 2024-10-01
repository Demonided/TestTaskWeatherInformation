package com.example.testtaskweatherinformation.domain.information

import com.example.testtaskweatherinformation.data.db.dao.WeatherDao
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun saveWeatherData(weather: WeatherResponse)

    suspend fun getWeatherDataById(id: Int): ListWeatherInformationEntity?

    suspend fun getAllWeatherData(): List<ListWeatherInformationEntity>

}