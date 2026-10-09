package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.DailyModel
import com.example.weatherapp.R



@Composable
fun DailyScreen() {
    val today = DailyModel("Wednesday",12,6,"Sunny")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFDE7))
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
            text = "Daily Forecast",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Halifax, NS",
            style = MaterialTheme.typography.bodyMedium
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
        ){
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = today.day,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Image(
                        painter = painterResource(
                            id = when (today.condition.lowercase()) {
                                "sunny" -> R.drawable.sunny
                                "rainy" -> R.drawable.rainy
                                "cloudy" -> R.drawable.cloudy
                                "foggy" -> R.drawable.foggy
                                "windy" -> R.drawable.windy
                                else -> R.drawable.cloudy
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Text("High: ${today.high}°C")
                Text("Low: ${today.low}°C")

                Text(today.condition)
            }
        }
    }

}
