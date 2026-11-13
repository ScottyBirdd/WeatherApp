package com.example.weatherapp.data.dao

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)
data class Current(
    @SerializedName("temp_c") val tempCelsius: Float,

    @SerializedName("feelslike_c") val feelsLike: Float,

    @SerializedName("wind_kph") val windSpeed: Float,

    @SerializedName("wind_dir") val windDirection: String,

    val humidity: Int,

    @SerializedName("chance_of_rain") val precipitationAmount: Float,

    val condition: Condition
)
data class Condition(
    val text: String,
    val icon: String
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