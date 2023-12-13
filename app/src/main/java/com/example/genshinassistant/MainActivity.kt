package com.example.genshinassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.genshinassistant.ui.theme.GenshinAssistantTheme
import com.example.genshinassistant.views.CharacterCardGridView
import com.example.genshinassistant.views.DetailPage
import com.example.genshinassistant.viewModels.NavigatorViewModel
import com.example.genshinassistant.views.AppContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinAssistantTheme {
                val navController = rememberNavController()
                val navigatorViewModel = viewModel<NavigatorViewModel>()
                AppContent(navController = navController, navigatorViewModel = navigatorViewModel)
            }
        }
    }


}
