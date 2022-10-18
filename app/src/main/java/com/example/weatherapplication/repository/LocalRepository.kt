package com.example.weatherapplication.repository

import com.example.weatherapplication.model.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}
