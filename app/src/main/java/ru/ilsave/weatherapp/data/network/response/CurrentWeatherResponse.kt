package ru.ilsave.weatherapp.data.network.response

import ru.ilsave.weatherapp.data.db.entity.Data


data class CurrentWeatherResponse(
    val count: Int,
    val data: List<Data>
)