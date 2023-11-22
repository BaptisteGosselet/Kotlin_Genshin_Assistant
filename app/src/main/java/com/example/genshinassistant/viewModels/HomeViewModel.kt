package com.example.genshinassistant.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.repository.APIService
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private val _characters = mutableStateOf<List<String>>(listOf());
    var errorMessage : String by mutableStateOf("");

    init{
        getCharacters();
    }
    private fun getCharacters() {
        viewModelScope.launch {
            val apiService = APIService.retrofitApiService;
            try {
                _characters.value = apiService.getAllCharacters()
            }
            catch (e: Exception){
                errorMessage = e.message.toString();
            }
        }
    }


}