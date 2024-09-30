package com.example.testtaskweatherinformation.data.information.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val coord: DataCoord,
    val weather: List<WeatherClouds>,
    val base: String,
    val main: WeatherTemp,
    val visibility: String,
    val wind: WeatherWind,
    val id: Int,
    val name: String,
    val cod: Int,
    val timestamp: Long = System.currentTimeMillis()
)

data class DataCoord(
    val lon: Double,
    val lat: Double
)

data class WeatherClouds(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherTemp(
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("grnd_level")
    val grndLevel: Int
)

data class WeatherWind(
    val speed: Double,
    val deg: Int,
    val gust: Double
)