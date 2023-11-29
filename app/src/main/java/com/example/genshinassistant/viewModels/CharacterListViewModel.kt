package com.example.genshinassistant.viewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.service.APIService
import kotlinx.coroutines.launch

class CharacterListViewModel() : ViewModel() {

    val apiService = APIService.retrofitApiService

    private val _characters = mutableStateOf<List<Character>>(emptyList())
    val characters: State<List<Character>> = _characters

    private val _names = mutableStateOf<List<String>>(emptyList())
    val names: State<List<String>> = _names

    val isLoading:MutableState<Boolean> = mutableStateOf(true);

    init{
        loadNames();
        loadCharacters();
        isLoading.value = false;
    }

    fun loadNames() {
        viewModelScope.launch {
            try {
                val names = apiService.getAllCharacters()
                _names.value = names
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun loadCharacters() {
        viewModelScope.launch {
            try {
                val charactersList = mutableListOf<Character>()
                for (name in _names.value) {
                    Log.d("grid", "VM : $name");
                    val character = apiService.getCharacterByName(name)
                    charactersList.add(character)
                }
                _characters.value = charactersList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
