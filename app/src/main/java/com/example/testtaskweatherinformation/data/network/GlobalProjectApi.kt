package com.example.testtaskweatherinformation.data.network

import com.example.testtaskweatherinformation.data.information.city.CityResponse
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GlobalProjectApi {

    @GET("/data/2.5/weather")
    suspend fun getInformationWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = "bf1a41c48dc76b77eeb996877d79137a",
        @Query("units") units: String = "metric"
    ): WeatherResponse

    @GET("/geo/1.0/direct")
    suspend fun getInformationCity(
        @Query("q") cityName: String,          // Название города
        @Query("limit") limit: Int = 1,        // Ограничение количества результатов
        @Query("appid") apiKey: String = "bf1a41c48dc76b77eeb996877d79137a" // API ключ
    ): List<CityResponse>
}