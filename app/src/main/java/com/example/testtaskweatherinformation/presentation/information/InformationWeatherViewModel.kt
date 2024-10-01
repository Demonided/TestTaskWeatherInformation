package com.example.testtaskweatherinformation.presentation.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskweatherinformation.data.information.weather.WeatherResponse
import com.example.testtaskweatherinformation.data.network.GlobalProjectApi
import com.example.testtaskweatherinformation.domain.information.WeatherRepository
import com.example.testtaskweatherinformation.util.debugLog
import kotlinx.coroutines.launch

class InformationWeatherViewModel(
    private val weatherApi: GlobalProjectApi,
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> = _weatherData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Функция для получения координат города и данных о погоде
    fun fetchWeatherByCity(cityName: String) {
        viewModelScope.launch {
            try {
                // Запрос на получение информации о городе
                val cityResponse = weatherApi.getInformationCity(cityName)

                if (cityResponse.isNotEmpty()) {
                    val city = cityResponse[0]
                    val lat = city.lat
                    val lon = city.lon

                    // Запрос на получение данных о погоде по координатам
                    val weatherResponse = weatherApi.getInformationWeather(lat, lon)
                    _weatherData.value = weatherResponse

                    debugLog(TAG) {
                        ("data weather = ${weatherResponse.id}")
                    }
                    weatherRepository.saveWeatherData(weatherResponse) // Сохранение данных в Room

                } else {
                    _error.value = "City not found"
                }

                debugLog(TAG) {
                    "Content state = ${cityResponse.size}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
                debugLog(TAG) {
                    "Content error"
                }
            }
        }
    }

    companion object {
        const val TAG = "InformationViewModel"
    }
}