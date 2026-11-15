package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel
import coil3.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier

@Composable
fun DailyScreen(viewModel: MainViewModel = viewModel()) {

    val weather = viewModel.weather
    val location = viewModel.location

    location?.let {
        viewModel.searchWeather(
            "${location.latitude},${location.longitude}"
        )
    }

    weather?.let {
        Column {

            Text(it.location.cityLocation)
            AsyncImage(
                model = "https:${it.current.condition.icon}",
                contentDescription = it.current.condition.text,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Fit
            )

            Text(it.current.condition.text)

            Text("${it.current.tempCelsius}°C")

            Text("Feels Like: ${it.current.feelsLike}°C")

            Text("Wind: ${it.current.windDirection} ${it.current.windSpeed} km/h")

            Text(  "Humidity: ${it.current.humidity}%")

            Text("Precipitation: ${it.current.precipitationAmount} mm")

            Text("Chance of Rain: ${it.current.chanceOfRain}%")

        }
    }

}
