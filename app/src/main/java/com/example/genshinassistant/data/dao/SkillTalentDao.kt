package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.SKILL_TALENT_TABLE
import com.example.genshinassistant.data.model.SkillTalent

@Dao
interface SkillTalentDao {

    @Query("SELECT * FROM $SKILL_TALENT_TABLE WHERE character_id = :characterId")
    fun getSkillTalentsByCharacterId(characterId: Int): List<SkillTalent>

    @Insert
    suspend fun addSkillTalent(skillTalent: SkillTalent) : Long

    @Insert
    suspend fun addAllSkillTalents(skillTalents: List<SkillTalent>)

    // Delete skill talent of a character
    @Query("DELETE FROM $SKILL_TALENT_TABLE WHERE character_id = :characterId")
    suspend fun deleteSkillTalentByCharacterId(characterId: Int)

    @Query("DELETE FROM $SKILL_TALENT_TABLE")
    suspend fun deleteAllSkillTalents()
}