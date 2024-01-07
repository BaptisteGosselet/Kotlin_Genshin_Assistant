package com.example.genshinassistant.data.repository

import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.dao.CharacterDao
import kotlinx.coroutines.flow.Flow

// Creer un nouveau type
typealias Characters = List<Character>

class CharacterRepository(private val characterDao: CharacterDao) {

    fun getAllCharactersFromRoom(): Flow<Characters> {
        return characterDao.getCharacters()
    }

    fun getCharacterByNameFromRoom(name: String): Character {
        return characterDao.getCharacterByName(name)
    }

    suspend fun addCharacterToRoom(character: Character): String {
        return characterDao.addCharacter(character)
    }

    suspend fun deleteCharacterFromRoom(character: Character) {
        characterDao.deleteCharacter(character)
    }

}