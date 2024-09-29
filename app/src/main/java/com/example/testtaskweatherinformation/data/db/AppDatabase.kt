package com.example.testtaskweatherinformation.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskweatherinformation.data.db.dao.WeatherDao
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity

@Database(
    version = 1,
    entities = [ListWeatherInformationEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun searchWeatherInformation(): WeatherDao
}