package com.example.genshinassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.genshinassistant.ui.theme.GenshinAssistantTheme
import com.example.genshinassistant.viewModels.CharacterListViewModel
import com.example.genshinassistant.viewModels.CharacterRoomViewModel
import com.example.genshinassistant.views.AppContent


class MainActivity : ComponentActivity() {
    val characterRoomViewModel: CharacterRoomViewModel by viewModels {
        CharacterRoomViewModel.CharacterRoomViewModelFactory((application as CharacterApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinAssistantTheme {
                val characterListViewModel = CharacterListViewModel()
                val navController = rememberNavController()

                AppContent(navController = navController, characterListViewModel = characterListViewModel, characterRoomViewModel = characterRoomViewModel)

            }
        }
    }

}
