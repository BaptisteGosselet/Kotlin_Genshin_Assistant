package com.example.genshinassistant.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.repository.CharacterRepository
import com.example.genshinassistant.data.repository.Characters
import kotlinx.coroutines.flow.Flow

class CharacterRoomViewModel(private val repository: CharacterRepository) : ViewModel() {

    var characters: Flow<Characters> = repository.getAllCharactersFromRoom()

    // un character pour utiliser add et delete
    var character by mutableStateOf(Character(0, "", "", "", "", "", "", 0, "", "", "", "", ""))

    fun getCharacterByName(name: String): Character {
        return repository.getCharacterByNameFromRoom(name)
    }

    suspend fun addCharacter(character: Character) {
        return repository.addCharacterToRoom(character)
    }

    suspend fun deleteCharacter(character: Character) {
        repository.deleteCharacterFromRoom(character)
    }

    class CharacterRoomViewModelFactory(private val repository: CharacterRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CharacterRoomViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CharacterRoomViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

