package com.example.genshinassistant.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.model.Constellation
import com.example.genshinassistant.data.model.PassiveTalent
import com.example.genshinassistant.data.model.SkillTalent
import com.example.genshinassistant.data.model.Upgrade
import com.example.genshinassistant.data.repository.CharacterRepository
import com.example.genshinassistant.data.repository.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CharacterRoomViewModel(private val repository: CharacterRepository) : ViewModel() {

    var characters: Flow<Characters> = repository.getAllCharactersFromRoom()

    // un character pour utiliser add et delete
    var character by mutableStateOf(Character(0, "", "", "", "", "", "", "", 0, "", "", "", "", ""))

    // une constellations pour utiliser add et delete
    var constellation by mutableStateOf(Constellation(0, "", 0, "", "", 0))

    // un passiveTalent pour utiliser add et delete
    var passiveTalent by mutableStateOf(PassiveTalent(0, "", 0, "", "", 0))

    // un skillTalent pour utiliser add et delete
    var skillTalent by mutableStateOf(SkillTalent(0, "", "", "", "", 0))

    // un upgrade pour utiliser add et delete
    var upgrade by mutableStateOf(Upgrade(0, "", "", 0))

    fun getCharacterByName(name: String): Character {
        viewModelScope.launch {
            try{
                character = repository.getCharacterByNameFromRoom(name)
            }
            catch (e: Exception){
                println(e.message.toString())
            }

        }
        return character
    }

    suspend fun addCharacter(character: Character) : Long {
        return repository.addCharacterToRoom(character)
    }

    suspend fun addConstellation(constellation: Constellation) : Long {
        return repository.addConstellationToRoom(constellation)
    }

    suspend fun addPassiveTalent(passiveTalent: PassiveTalent) : Long {
        return repository.addPassiveTalentToRoom(passiveTalent)
    }

    suspend fun addSkillTalent(skillTalent: SkillTalent) : Long {
        return repository.addSkillTalentToRoom(skillTalent)
    }

    suspend fun addUpgrade(upgrade: Upgrade) : Long {
        return repository.addUpgradeToRoom(upgrade)
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

