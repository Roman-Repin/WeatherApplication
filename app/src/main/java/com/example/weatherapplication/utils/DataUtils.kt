package com.example.weatherapplication.utils

import com.example.weatherapplication.model.FactDTO
import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.model.WeatherDTO
import com.example.weatherapplication.model.getDefaultCity


fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact: FactDTO = weatherDTO.fact!!
    return listOf(Weather(getDefaultCity(), fact.temp!!, fact.feels_like!!,
        fact.condition!!, fact.icon))
}
