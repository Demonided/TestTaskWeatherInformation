package com.example.testtaskweatherinformation.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_information")
data class ListWeatherInformationEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val speed: Double,
    val lon: Double,
    val lat: Double,
    val timestamp: Long = System.currentTimeMillis()
)