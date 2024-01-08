package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.CHARACTER_TABLE
import com.example.genshinassistant.data.repository.Characters
import kotlinx.coroutines.flow.Flow
import com.example.genshinassistant.data.model.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM $CHARACTER_TABLE")
    fun getCharacters(): Flow<Characters>

    @Query("SELECT * FROM $CHARACTER_TABLE WHERE name = :name")
    fun getCharacterByName(name: String): Character

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCharacter(character: Character) : Long

    @Delete
    suspend fun deleteCharacter(character: Character)

    @Query("DELETE FROM $CHARACTER_TABLE")
    suspend fun deleteAllCharacters()
}