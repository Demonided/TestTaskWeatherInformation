package com.example.testtaskweatherinformation.data.converter

import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse

object ConverterEntity {

    fun WeatherResponse.mapToListWeatherInformation(): ListWeatherInformationEntity =
        ListWeatherInformationEntity (
            id = id,
            name = name,
            temp = main.temp,
            pressure = main.pressure,
            humidity = main.humidity,
            speed = wind.speed,
            lon = coord.lon,
            lat = coord.lat
        )
}