
package com.example.weatherapp.ui.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import androidx.compose.foundation.lazy.items



@Composable
fun WeatherScreen(viewModel: MainViewModel = viewModel()) {

    val location = viewModel.location

    location?.let {
        viewModel.searchWeather(
            "${location.latitude},${location.longitude}"
        )
    }
    val weather = viewModel.weather

    weather?.let {

        LazyColumn {

            items(it.forecast.forecastday) { day ->

                Card(
                    modifier = Modifier.padding(8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(day.date)

                        AsyncImage(
                            model = "https:${day.day.condition.icon}",
                            contentDescription = day.day.condition.text,
                            modifier = Modifier.size(64.dp)
                        )

                        Text(day.day.condition.text)

                        Text("High: ${day.day.maxTemp}°C")

                        Text("Low: ${day.day.minTemp}°C")

                        Text("Wind: ${day.day.maxWind} km/h")

                        Text("Humidity: ${day.day.humidity}%")

                        Text("Precipitation: ${day.day.precipitationAmount} mm")

                        Text("Chance of Rain: ${day.day.chanceOfRain}%")
                    }
                }
            }
        }
    }


    }


