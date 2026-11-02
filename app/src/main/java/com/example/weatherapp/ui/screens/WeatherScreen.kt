
package com.example.weatherapp.ui.screens
import androidx.compose.runtime.Composable

@Composable
fun WeatherScreen() {
    // placeholder data for weather
//    val weeklyForecast = listOf(
//        DailyModel("Monday", 10, 5, "Sunny"),
//        DailyModel("Tuesday", 15, 10, "Rainy"),
//        DailyModel("Wednesday", 20, 10, "Cloudy"),
//        DailyModel("Thursday", 5, 3, "Windy"),
//        DailyModel("Friday", 15, 8, "Foggy"),
//        DailyModel("Saturday", 5, 0, "Sunny"),
//        DailyModel("Sunday", 15, 10, "Rainy"),
//
//        )
//    Column( // main screen layout for weekly forecast screen
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFBEE3FF))
//            .padding(25.dp)
//
//    ) {
//        Text(
//            text = "Weekly Forecast",
//            style = MaterialTheme.typography.headlineLarge,
//            fontFamily = FontFamily.SansSerif,
//            color = Color(0xFF0D47A1)
//
//        )
//        Text(
//            text = "Halifax, NS",
//            style = MaterialTheme.typography.bodyMedium,
//            fontFamily = FontFamily.SansSerif,
//            color = Color(0xFF0D47A1)
//
//        )
//        Spacer(modifier = Modifier.height(12.dp))
//
//        LazyColumn( // lazy column to make each days forecast scrollable in a list
//            modifier = Modifier.padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(weeklyForecast) { day ->
//                Card( // card that shows each days weather
//                    modifier = Modifier.fillMaxWidth(),
//                    shape = RoundedCornerShape(50.dp),
//                    elevation = CardDefaults.cardElevation(6.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
//                ) {
//                    Row( // layout for day, icon, name and temp
//                        modifier = Modifier
//                            .padding(24.dp)
//                            .fillMaxWidth()
//                            .height(80.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//
//                    ) {
//                        Row( // row for the day and weather icon
//                            modifier = Modifier.weight(1f),
//                            horizontalArrangement = Arrangement.spacedBy(12.dp),
//                            verticalAlignment = Alignment.CenterVertically) {
//
//                            Text(
//                                text = day.day,
//                                style = MaterialTheme.typography.titleMedium,
//                                fontWeight = FontWeight.Bold,
//                                color = Color(0xFF1565C0)
//                            )
//
//                            Image(
//                                painter = painterResource(
//                                    id = when (day.condition.lowercase()) {
//                                        "sunny" -> R.drawable.sunny
//                                        "rainy" -> R.drawable.rainy
//                                        "cloudy" -> R.drawable.cloudy
//                                        "foggy" -> R.drawable.foggy
//                                        "windy" -> R.drawable.windy
//                                        else -> R.drawable.cloudy
//                                    }
//                                ),
//                                contentDescription = null,
//                                modifier = Modifier.size(32.dp)
//                            )
//
//                        }
//
//                        Column( // high and low temps and condition
//                            modifier = Modifier.weight(1f),
//                            horizontalAlignment = Alignment.End
//                        ) {
//                            Text("High: ${day.high}°C", color = Color(0xFF1565C0))
//                            Text("Low: ${day.low}°C", color = Color(0xFF1565C0))
//                            Text(day.condition, color = Color(0xFF1565C0))
//                        }
//
//                    }
//                }
//
//            }
//        }
//    }
}
