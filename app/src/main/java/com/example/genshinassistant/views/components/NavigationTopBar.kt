package com.example.genshinassistant.views.components

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
import com.example.genshinassistant.navigation.NavigationItem
import com.example.genshinassistant.viewModels.NavigatorViewModel

@Composable
fun NavigationTopBar(navController: NavController, navigatorViewModel: NavigatorViewModel) {

    // on garde en mémoire le dernier item cliqué. Par défaut on ne veut rien de sélectionné.
    var selectedItem by remember { mutableStateOf(-1) }

    // liste des items de la barre
    val navigationItems = listOf(
        NavigationItem.Grid,
        NavigationItem.List,
        NavigationItem.Favorites
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(item.icon.asPainterResource(), contentDescription = null)
                },
//                    selected = selectedItem == index,
                selected = navigatorViewModel.currentItem.value == item,
                onClick = {
                    navController.navigate(item.label) {
                        popUpTo("grid")
                    }
                    navigatorViewModel.navigateTo(item)
                    selectedItem = index
                }
            )
        }
    }
}