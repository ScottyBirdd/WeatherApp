/*
    Scott Fahie - W0516602
    MOBI3002 - Weather App Phase 1
    This program was written with assistance from:
    https://developer.android.com/studio/write/create-app-icons
    https://ktdevlog.com/build-a-weather-app-in-kotlin/
    https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState
    https://www.w3resource.com/kotlin-exercises/basic/kotlin-basic-exercise-11.php
    https://developer.android.com/develop/ui/compose/state
 */

package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weatherapp.navigation.Navigation
import com.example.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                    Navigation()
                }
            }
        }
    }




