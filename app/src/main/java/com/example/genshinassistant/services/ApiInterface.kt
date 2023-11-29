package com.example.genshinassistant.service

import com.example.genshinassistant.models.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/characters")
    suspend fun getAllCharacters(): List<String>

    @GET("/characters/{name}")
    suspend fun getCharacterByName(@Path("name") name: String): Character

}