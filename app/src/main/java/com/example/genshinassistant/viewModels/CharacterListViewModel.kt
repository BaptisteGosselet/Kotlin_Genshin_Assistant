package com.example.genshinassistant.viewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.service.APIService
import kotlinx.coroutines.launch

class CharacterListViewModel() : ViewModel() {

    val apiService = APIService.retrofitApiService;
    var errorMessage: String by mutableStateOf("");

    private val _characters = mutableStateOf<List<Character>>(listOf());
    val characters: State<List<Character>> = _characters;

    init {
        loadCharacters();
    }

    private fun loadCharacters() {
        viewModelScope.launch {

            lateinit var names: List<String>;

            try {
                names = apiService.getAllCharacters();
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }

            var charactersList:MutableList<Character> = mutableListOf();
            for(name in names){
                try{
                    var c:Character = apiService.getCharacterByName(name);
                    c.nameId = name;
                    charactersList.add(c);
                }
                catch (e: Exception){
                    errorMessage = e.message.toString();
                }
            }

            _characters.value = charactersList;
        }
    }

}
