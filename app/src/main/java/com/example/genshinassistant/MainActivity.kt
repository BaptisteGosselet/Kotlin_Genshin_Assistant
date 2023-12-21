package com.example.genshinassistant

import AppContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.genshinassistant.ui.theme.GenshinAssistantTheme
import com.example.genshinassistant.viewModels.CharacterListViewModel
import com.example.genshinassistant.views.DetailPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinAssistantTheme {
                val characterListViewModel = CharacterListViewModel()
                val navController = rememberNavController()

                AppContent(navController = navController, characterListViewModel = characterListViewModel)

            }
        }
    }

}
