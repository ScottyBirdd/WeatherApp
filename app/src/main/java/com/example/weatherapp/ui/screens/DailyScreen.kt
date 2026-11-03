package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel

@Composable
fun DailyScreen(viewModel: MainViewModel = viewModel()) {

    val weather = viewModel.weather
    val location = viewModel.location

    viewModel.searchWeather(
        query = "Halifax, Canada"
    )

    weather?.let {
        Column {
            Text(it.location.cityLocation)

            Text("${it.current.tempCelsius}°C")

            location?.let {
                Text("Latitude: ${location.latitude}")
                Text("Longitude: ${location.longitude}")
            }
        }
    }

}
