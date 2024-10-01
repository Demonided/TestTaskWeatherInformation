package com.example.testtaskweatherinformation.presentation.listniformationweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskweatherinformation.data.db.model.ListWeatherInformationEntity
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import com.example.testtaskweatherinformation.domain.information.WeatherRepository
import com.example.testtaskweatherinformation.util.debugLog
import kotlinx.coroutines.launch

class ListInformationWeatherViewModel(
    private val weatherRepository: WeatherRepository
): ViewModel() {

    // LiveData для данных из базы
    private val _weatherData = MutableLiveData<List<ListWeatherInformationEntity>>()
    val weatherData: LiveData<List<ListWeatherInformationEntity>> = _weatherData

    init {
        loadWeatherData()
    }

    // Метод для загрузки данных (если необходимо)
    fun loadWeatherData() {
        viewModelScope.launch {
            val data = weatherRepository.getAllWeatherData()
            debugLog(TAG) {
                ("Data ViewModel = $data")
            }
            _weatherData.value = data
        }
    }

    companion object {
        const val TAG = "ListInformationWeatherViewModel"
    }
}