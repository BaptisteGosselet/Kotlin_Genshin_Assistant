package com.example.genshinassistant.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.genshinassistant.viewModels.NavigatorViewModel
import com.example.genshinassistant.views.components.NavigationTopBar
import com.example.genshinassistant.views.pages.FavoritesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navController: NavHostController, navigatorViewModel: NavigatorViewModel) {
    Scaffold(
        topBar = {
            NavigationTopBar(navController = navController, navigatorViewModel = navigatorViewModel)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NavHost(navController = navController, startDestination = "grid") {
                composable("grid") {
                    GridList()
                }
                composable("list") {
                    RowList()
                }
                composable("favorites") {
                    FavoritesScreen()
                }
            }
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button  times.
                """.trimIndent(),
            )

        }
    }
}

