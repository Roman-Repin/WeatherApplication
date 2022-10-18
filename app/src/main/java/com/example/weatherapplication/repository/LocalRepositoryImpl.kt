package com.example.weatherapplication.repository

import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.room.HistoryDao
import com.example.weatherapplication.utils.convertHistoryEntityToWeather
import com.example.weatherapplication.utils.convertWeatherToEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao) :
    LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }
    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}