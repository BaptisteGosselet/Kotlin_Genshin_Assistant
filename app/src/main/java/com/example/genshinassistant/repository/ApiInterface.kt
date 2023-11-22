package com.example.genshinassistant.repository

import com.example.genshinassistant.models.Character
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/characters")
    suspend fun getAllCharacters(): List<String>

    @GET("/characters/{name}")
    suspend fun getCharacterByName(@Path("name") name: String): Character

    @GET("/characters/{name}/icon-big")
    fun getCharacterIcon(@Path("name") name:String): ResponseBody
}