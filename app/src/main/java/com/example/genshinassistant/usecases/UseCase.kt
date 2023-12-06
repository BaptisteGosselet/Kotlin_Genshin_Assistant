package com.example.genshinassistant.repository

import com.example.genshinassistant.models.Character
class UseCase {
    private val repo = Repository();

    suspend fun getAllCharacters(): List<String>{
        return repo.getAllCharacters();
    }

    suspend fun getCharacterByName(name: String): Character{
        return repo.getCharacterByName(name);
    }


}