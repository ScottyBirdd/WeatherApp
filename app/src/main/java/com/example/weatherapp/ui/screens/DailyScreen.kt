package com.example.weatherapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel
import coil3.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFBEE3FF)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF9C4)
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = it.location.cityLocation,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    AsyncImage(
                        model = "https:${it.current.condition.icon}",
                        contentDescription = it.current.condition.text,
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Fit
                    )

                    Text(
                        text = it.current.condition.text,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "${it.current.tempCelsius}°C",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Feels Like: ${it.current.feelsLike}°C",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        "Wind: ${it.current.windDirection} ${it.current.windSpeed} km/h",
                        style = MaterialTheme.typography.bodyLarge
                    )



                    Text(
                        "Precipitation: ${it.current.precipitationAmount} mm",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        "Chance of Rain: ${it.current.chanceOfRain}%",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        "Humidity: ${it.current.humidity}%",
                        style = MaterialTheme.typography.bodyLarge
                    )

                }
            }

        }
    }
}

