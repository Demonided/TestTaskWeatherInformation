package com.example.testtaskweatherinformation.data.information

import com.example.testtaskweatherinformation.data.converter.ConverterEntity.mapToListWeatherInformation
import com.example.testtaskweatherinformation.data.db.AppDatabase
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import com.example.testtaskweatherinformation.domain.information.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl (private val appDB: AppDatabase): WeatherRepository {

    override suspend fun saveWeatherData(weather: WeatherResponse) {
        appDB.searchWeatherInformation().insertWeather(weather.mapToListWeatherInformation())
    }

    override suspend fun getWeatherDataById(id: Int): ListWeatherInformationEntity? {
        return appDB.searchWeatherInformation().getWeatherById(id)
    }

    override suspend fun getAllWeatherData(): List<ListWeatherInformationEntity> {
        return appDB.searchWeatherInformation().getAllWeather()
    }
}