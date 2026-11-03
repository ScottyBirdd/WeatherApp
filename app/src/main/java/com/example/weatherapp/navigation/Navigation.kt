package com.example.weatherapp.navigation

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.DailyScreen
import com.example.weatherapp.ui.screens.WeatherScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0
    val viewModel: MainViewModel = viewModel()
    // Begin: Ask permission to get device location.
    // Note: If permission is previously granted, the dialog won't appear and refreshLocation() will get called.
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        if (results.values.any { it }) {
            viewModel.refreshLocation() // call a function to get the current location for device
        }
    }

    LaunchedEffect(Unit) {
        launcher.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }
    // End: Ask permission to get device location.


    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFFEEEEEE),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("The Weather Centre")
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFEEEEEE),
                windowInsets = NavigationBarDefaults.windowInsets)
            {
                NavigationBarItem(
                    icon = { Icon(imageVector = Icons.Default.Today, contentDescription = "Daily") },
                    label = { Text("Daily Forecast") },
                    selected = selectedIndex == 0,
                    onClick = {selectedIndex = 0
                        navController.navigate(route="Daily Forecast"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }}
                )
                NavigationBarItem(
                    icon = { Icon(imageVector = Icons.Default.CalendarMonth, contentDescription = "Weekly") },
                    label = { Text("Weekly Forecast") },
                    selected = selectedIndex == 1,
                    onClick = {selectedIndex = 1
                        navController.navigate(route="Weekly Forecast"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }}
                )
            }
        }


    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "Daily Forecast",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "Daily Forecast") {
                DailyScreen(viewModel)
            }
            composable(route = "Weekly Forecast") {
                WeatherScreen()
            }
        }
        Text("",modifier = Modifier.padding(paddingValues = innerPadding))
    }
}