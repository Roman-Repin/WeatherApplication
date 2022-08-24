package com.example.weatherapplication.viewmodel

import com.example.weatherapplication.model.Weather

sealed class AppState {
    data class Success (val weatherData: List<Weather>): AppState()
    data class Error (val error: Throwable): AppState()
    object Loading: AppState()
}
