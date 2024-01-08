package com.example.genshinassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.genshinassistant.Utils.Companion.UPGRADE_TABLE
import com.example.genshinassistant.data.model.Upgrade

@Dao
interface UpgradeDao {

    @Query("SELECT * FROM $UPGRADE_TABLE WHERE skillTalent_id = :skillTalentId")
    fun getUpgradesBySkillTalentId(skillTalentId: Int): List<Upgrade>

    @Insert
    suspend fun addUpgrade(upgrade: Upgrade) : Long

    @Insert
    suspend fun addAllUpgrades(upgrades: List<Upgrade>)

    // Delete upgrade of a skill talent
    @Query("DELETE FROM $UPGRADE_TABLE WHERE skillTalent_id = :skillTalentId")
    suspend fun deleteUpgradeBySkillTalentId(skillTalentId: Int)

    @Query("DELETE FROM $UPGRADE_TABLE")
    suspend fun deleteAllUpgrades()
}