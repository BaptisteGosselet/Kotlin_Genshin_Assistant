package com.example.genshinassistant.views.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.genshinassistant.R
import com.example.genshinassistant.navigation.IconResource
import com.example.genshinassistant.navigation.RouteNames

@Composable
fun NavigationTopBar(navController: NavController) {

    // on garde en mémoire le dernier item cliqué. Par défaut la première icône.
    var selectedItem by remember { mutableStateOf(0) }
    val defaultRoute = RouteNames.grid

    NavigationBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavigationBarItem(
            icon = {
                Icon(IconResource.fromDrawableResource(R.drawable.baseline_grid_view).asPainterResource(), contentDescription = null)
            },
            selected = selectedItem == 0,
            onClick = {
                navController.navigate(RouteNames.grid) {
                    popUpTo(defaultRoute)
                }
                selectedItem = 0
            }
        )

        NavigationBarItem(
            icon = {
                Icon(IconResource.fromImageVector(Icons.Filled.List).asPainterResource(), contentDescription = null)
            },
            selected = selectedItem == 1,
            onClick = {
                navController.navigate(RouteNames.list) {
                    popUpTo(defaultRoute)
                }
                selectedItem = 1
            }
        )

        NavigationBarItem(
            icon = {
                Icon(IconResource.fromImageVector(Icons.Filled.Favorite).asPainterResource(), contentDescription = null)
            },
            selected = selectedItem == 2,
            onClick = {
                navController.navigate(RouteNames.favorites) {
                    popUpTo(defaultRoute)
                }
                selectedItem = 2
            }
        )
    }
}