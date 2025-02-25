package com.example.genshinassistant.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.genshinassistant.navigation.RouteNames
import com.example.genshinassistant.viewModels.CharacterListViewModel
import com.example.genshinassistant.viewModels.CharacterRoomViewModel
import com.example.genshinassistant.views.components.NavigationTopBar
import com.example.genshinassistant.views.pages.DetailPage
import com.example.genshinassistant.views.pages.FavoritesScreen
import com.example.genshinassistant.views.pages.GridList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navController: NavHostController, characterListViewModel: CharacterListViewModel, characterRoomViewModel: CharacterRoomViewModel) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val shouldShowNavBar = navBackStackEntry?.destination?.route?.startsWith(RouteNames.details) != true


    Scaffold(
        topBar = {
            NavigationTopBar(navController = navController, showBar = shouldShowNavBar)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NavHost(navController = navController, startDestination = "grid") {
                composable(RouteNames.grid) {
                    GridList(characterListViewModel, navController)
                }
                composable(RouteNames.list) {
                    RowList(characterListViewModel, navController)
                }
                composable(RouteNames.favorites) {
                    FavoritesScreen(characterRoomViewModel = characterRoomViewModel, navController = navController)
                }
                composable(RouteNames.details + "/{nameId}", arguments = listOf(navArgument("nameId") { type = NavType.StringType })) { backStackEntry ->
                    DetailPage(nameId = backStackEntry.arguments?.getString("nameId").toString(), characterRoomViewModel)
                }
            }
        }
    }
}