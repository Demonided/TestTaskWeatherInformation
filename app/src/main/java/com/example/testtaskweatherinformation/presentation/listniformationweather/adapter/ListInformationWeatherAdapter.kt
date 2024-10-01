package com.example.testtaskweatherinformation.presentation.listniformationweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskweatherinformation.R
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse

class ListInformationWeatherAdapter(
    private var weather: List<ListWeatherInformationEntity>
) : RecyclerView.Adapter<ListInformationWeatherViewHolder>() {

    var weatherClicked: (ListWeatherInformationEntity) -> Unit = {}

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

    // Метод для обновления данных
    fun updateWeatherData(newWeather: List<ListWeatherInformationEntity>) {
        weather = newWeather
        notifyDataSetChanged()  // Сообщаем адаптеру, что данные изменились
    }
}