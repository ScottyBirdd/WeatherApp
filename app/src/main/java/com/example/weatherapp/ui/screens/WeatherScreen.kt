



package com.example.weatherapp.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.DailyModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R

@Composable
fun WeatherScreen() {
    // placeholder data for weather
    val weeklyForecast = listOf(
        DailyModel("Monday", 10, 5, "Sunny"),
        DailyModel("Tuesday", 15, 10, "Rainy"),
        DailyModel("Wednesday", 20, 10, "Cloudy"),
        DailyModel("Thursday", 5, 3, "Windy"),
        DailyModel("Friday", 15, 8, "Foggy"),
        DailyModel("Saturday", 5, 0, "Sunny"),
        DailyModel("Sunday", 15, 10, "Rainy"),

        )
    Column(modifier = Modifier.padding(25.dp)) {
        Text(
            text = "Weekly Forecast",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Halifax, NS",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(weeklyForecast) { day ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .height(80.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = day.day,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Image(
                                painter = painterResource(
                                    id = when (day.condition.lowercase()) {
                                        "sunny" -> R.drawable.sunny
                                        "rainy" -> R.drawable.rainy
                                        "cloudy" -> R.drawable.cloudy
                                        "foggy" -> R.drawable.foggy
                                        "windy" -> R.drawable.windy
                                        else -> R.drawable.cloudy
                                    }
                                ),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )

                        }

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.End
                        ) {
                            Text("High: ${day.high}°C")
                            Text("Low: ${day.low}°C")
                            Text(day.condition)
                        }

                    }
                }

            }
        }
    }
}
