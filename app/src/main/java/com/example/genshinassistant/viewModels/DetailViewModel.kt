package com.example.genshinassistant.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.repository.UseCase
import kotlinx.coroutines.launch

class DetailViewModel(nameId:String) : ViewModel() {

    val useCase = UseCase();
    var errorMessage: String by mutableStateOf("");

    private var _character = mutableStateOf<Character?>(null);
    val character: State<Character?> = _character;

    init {
        loadCharacter(nameId);
    }

    private fun loadCharacter(nameId: String) {
        viewModelScope.launch {
            try {
                _character.value = useCase.getCharacterByName(nameId);
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}
