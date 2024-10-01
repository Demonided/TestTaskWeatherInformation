package com.example.testtaskweatherinformation.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: ListWeatherInformationEntity)

    @Query("SELECT * FROM weather_information WHERE id = :id")
    suspend fun getWeatherById(id: Int): ListWeatherInformationEntity?

    @Query("SELECT * FROM weather_information")
    suspend fun getAllWeather(): List<ListWeatherInformationEntity>

}