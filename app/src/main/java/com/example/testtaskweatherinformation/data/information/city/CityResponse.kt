package com.example.testtaskweatherinformation.data.information.city

data class CityResponse(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String
)
