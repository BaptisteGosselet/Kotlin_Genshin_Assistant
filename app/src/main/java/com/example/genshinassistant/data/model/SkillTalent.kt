package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.SKILL_TALENT_TABLE

@Entity(tableName = SKILL_TALENT_TABLE)
data class SkillTalent(
    @PrimaryKey(autoGenerate = true)
    val description: String,
    val name: String,
    val type: String,
    val unlock: String,
    val upgrades: List<Upgrade>
)
