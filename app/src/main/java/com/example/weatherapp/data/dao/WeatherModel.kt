package com.example.weatherapp.data.dao

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)
data class Current(
    @SerializedName("temp_c") val tempCelsius: Float
)
data class Location(
    @SerializedName("name") val cityLocation: String
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String
)