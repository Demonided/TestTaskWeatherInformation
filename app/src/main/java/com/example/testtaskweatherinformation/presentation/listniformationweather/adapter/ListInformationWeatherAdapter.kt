package com.example.testtaskweatherinformation.presentation.listniformationweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskweatherinformation.R
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse

class ListInformationWeatherAdapter(
    private val weather: List<WeatherResponse>
) : RecyclerView.Adapter<ListInformationWeatherViewHolder>() {

    var weatherClicked: (WeatherResponse) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListInformationWeatherViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_weather,
                parent,
                false
            )
        return ListInformationWeatherViewHolder(view, weatherClicked)
    }

    override fun onBindViewHolder(holder: ListInformationWeatherViewHolder, position: Int) {
        holder.bind(weather[position])
    }

    override fun getItemCount(): Int = weather.size
}