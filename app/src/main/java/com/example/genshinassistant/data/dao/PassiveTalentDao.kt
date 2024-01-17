package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.PASSIVE_TALENT_TABLE
import com.example.genshinassistant.data.model.PassiveTalent

@Dao
interface PassiveTalentDao {

    @Query("SELECT * FROM $PASSIVE_TALENT_TABLE WHERE nameId = :nameId")
    fun getPassiveTalentsByNameId(nameId: String): List<PassiveTalent>

    @Insert
    suspend fun addPassiveTalent(passiveTalent: PassiveTalent) : Long

    @Insert
    suspend fun addAllPassiveTalents(passiveTalents: List<PassiveTalent>)

    // Delete passive talent of a character
    @Query("DELETE FROM $PASSIVE_TALENT_TABLE WHERE nameId = :nameId")
    suspend fun deletePassiveTalentByNameId(nameId: String)

    @Query("DELETE FROM $PASSIVE_TALENT_TABLE")
    suspend fun deleteAllPassiveTalents()
}