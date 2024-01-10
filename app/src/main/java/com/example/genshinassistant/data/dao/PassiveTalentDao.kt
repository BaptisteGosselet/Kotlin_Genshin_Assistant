package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.PASSIVE_TALENT_TABLE
import com.example.genshinassistant.data.model.PassiveTalent

@Dao
interface PassiveTalentDao {

    @Query("SELECT * FROM $PASSIVE_TALENT_TABLE WHERE character_id = :characterId")
    fun getPassiveTalentsByCharacterId(characterId: Int): List<PassiveTalent>

    @Insert
    suspend fun addPassiveTalent(passiveTalent: PassiveTalent) : Long

    @Insert
    suspend fun addAllPassiveTalents(passiveTalents: List<PassiveTalent>)

    // Delete passive talent of a character
    @Query("DELETE FROM $PASSIVE_TALENT_TABLE WHERE character_id = :characterId")
    suspend fun deletePassiveTalentByCharacterId(characterId: Int)

    @Query("DELETE FROM $PASSIVE_TALENT_TABLE")
    suspend fun deleteAllPassiveTalents()
}