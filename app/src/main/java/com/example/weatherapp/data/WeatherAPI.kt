package com.example.weatherapp.data


import com.example.weatherapp.data.dao.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {

        // https://api.weatherapi.com/v1/forecast.json?key=ea090b434cc8445287a180212261910&q=Halifax%2c+Canada&days=3&aqi=no&alerts=no
        @GET("v1/forecast.json")
        suspend fun searchWeather(
            @Query("key") key: String,
            @Query("q") location: String,
            @Query("days") days: Int
        ): WeatherModel
    }
