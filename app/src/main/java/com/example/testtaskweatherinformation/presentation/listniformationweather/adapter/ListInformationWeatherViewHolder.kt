package com.example.testtaskweatherinformation.presentation.listniformationweather.adapter

import android.icu.text.SimpleDateFormat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskweatherinformation.R
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import java.util.Date
import java.util.Locale

class ListInformationWeatherViewHolder(
    itemView: View,
    private val weatherClicked: (ListWeatherInformationEntity) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val weatherNameCity: TextView = itemView.findViewById(R.id.item_city)
    private val weatherTemp: TextView = itemView.findViewById(R.id.item_temp)
    private val weatherDateTime: TextView = itemView.findViewById(R.id.item_time)

    fun bind(model: ListWeatherInformationEntity) {
        weatherNameCity.text = model.name
        weatherTemp.text = model.temp.toString()
        weatherDateTime.text = formatTimestamp(model.timestamp)

        itemView.setOnClickListener { weatherClicked(model) }
    }

    fun formatTimestamp(timestamp: Long): String {
        // Создаем объект SimpleDateFormat с нужным форматом
        val sdf = SimpleDateFormat("dd.MM.yyyy H:mm", Locale.getDefault())

        // Преобразуем timestamp в объект Date
        val date = Date(timestamp)

        // Возвращаем отформатированную строку
        return sdf.format(date)
    }
}