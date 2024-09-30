package com.example.testtaskweatherinformation.presentation.listniformationweather.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskweatherinformation.R
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import com.example.testtaskweatherinformation.databinding.ItemWeatherBinding

class ListInformationWeatherViewHolder(
    itemView: View,
    private val weatherClicked: (WeatherResponse) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val weatherNameCity: TextView = itemView.findViewById(R.id.item_city)
    private val weatherTemp: TextView = itemView.findViewById(R.id.item_temp)
    private val weatherDateTime: TextView = itemView.findViewById(R.id.item_time)

    fun bind(model: WeatherResponse) {
        weatherNameCity.text = model.name
        weatherTemp.text = model.main.temp.toString()
        weatherDateTime.text = model.timestamp.toString()

        itemView.setOnClickListener { weatherClicked(model) }
    }
}