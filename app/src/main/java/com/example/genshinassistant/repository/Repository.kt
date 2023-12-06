package com.example.genshinassistant.repository

import com.example.genshinassistant.models.Character
import com.example.genshinassistant.service.APIService

class Repository {
    private val apiService = APIService.retrofitApiService;

    suspend fun getAllCharacters(): List<String>{
        return apiService.getAllCharacters();
    }

    suspend fun getCharacterByName(name: String): Character{
        return apiService.getCharacterByName(name);
    }


}