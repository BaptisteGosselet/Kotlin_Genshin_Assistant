package com.example.genshinassistant.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.repository.CharacterRepository
import com.example.genshinassistant.data.repository.Characters
import kotlinx.coroutines.flow.Flow

class CharacterRoomViewModel(private val repository: CharacterRepository) : ViewModel() {

    var characters: Flow<Characters> = repository.getAllCharactersFromRoom()

    // un character pour utiliser add et delete
    var character by mutableStateOf(Character(0, "", "", "", listOf(), "", "", "", listOf(), 0, listOf(), "", "", "", "", ""))

    fun getCharacterByName(name: String): Character {
        return repository.getCharacterByNameFromRoom(name)
    }

    suspend fun addCharacter(character: Character): String {
        return repository.addCharacterToRoom(character)
    }

    suspend fun deleteCharacter(character: Character) {
        repository.deleteCharacterFromRoom(character)
    }
}