package com.example.weatherapplication.repository

import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.model.getRussianCities
import com.example.weatherapplication.model.getWorldCities

class RepositoryImpl: Repository {

    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}