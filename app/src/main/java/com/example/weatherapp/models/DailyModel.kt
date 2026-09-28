package com.example.weatherapp.models

data class DailyModel(
    val day: String,
    val high: Int,
    val low: Int,
    val condition: String
)