package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.DailyModel

@Composable
fun WeatherScreen() {
    Text("Weather Screen!")

    // placeholder data for weather
    val weeklyForecast = listOf(
        DailyModel("Monday", 10,5,"Sunny"),
        DailyModel("Tuesday", 15,10,"Rainy"),
        DailyModel("Wednesday", 20,10,"Cloudy"),
        DailyModel("Thursday", 5,3,"Clear"),
        DailyModel("Friday", 15,8,"Overcast"),

    )

    Column{
        weeklyForecast.forEach { day ->
            Text(text = day.day)
            Text(text = "High: ${day.high}C  Low: ${day.low}C")
            Text(text = day.condition)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}