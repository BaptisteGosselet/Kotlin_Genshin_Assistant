package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.CONSTELLATION_TABLE
import com.example.genshinassistant.data.model.Constellation

@Dao
interface ConstellationDao {

    @Query("SELECT * FROM $CONSTELLATION_TABLE WHERE nameId = :nameId")
    fun getConstellationsByNameId(nameId: String): List<Constellation>

    @Insert
    suspend fun addConstellation(constellation: Constellation) : Long

    @Insert
    suspend fun addAllConstellations(constellations: List<Constellation>)

    // Delete constellation of a character
    @Query("DELETE FROM $CONSTELLATION_TABLE WHERE nameId = :nameId")
    suspend fun deleteConstellationByNameId(nameId: String)

    @Query("DELETE FROM $CONSTELLATION_TABLE")
    suspend fun deleteAllConstellations()
}