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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.DailyModel
import com.example.weatherapp.R
import androidx.compose.runtime.setValue

fun celsiusToFar(c: Int): Int = ((c * 9) / 5) + 32 // function for converting temp
@Composable
fun DailyScreen() {
    val today = DailyModel("Wednesday",12,6,"Sunny")
    var useFahrenheit by remember { mutableStateOf(false) } // toggle state for switching

    Column( // main screen layout and background style
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
            .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
            text = "Daily Forecast",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF0D47A1)
        )
        Text(
            text = "Halifax, NS",
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF0D47A1)
        )
        Card( // card with todays details
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
        ){
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Show Fahrenheit")
                    Switch(
                        checked = useFahrenheit,
                        onCheckedChange = { useFahrenheit = it }
                    )
                }
                Row( // row for day label and icon
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = today.day,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
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
                        modifier = Modifier.size(40.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF1565C0))
                    )
                }
                // convert temps based on toggle state
                val high = if (useFahrenheit) celsiusToFar(today.high) else today.high
                val low = if (useFahrenheit) celsiusToFar(today.low) else today.low
                val unit = if (useFahrenheit) "°F" else "°C"
                Text(
                    "High: $high$unit",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF1565C0)
                )
                Text(
                    "Low: $low$unit",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF1565C0)
                )
                Text(
                    today.condition,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF1565C0)
                )
            }
        }
    }


}
