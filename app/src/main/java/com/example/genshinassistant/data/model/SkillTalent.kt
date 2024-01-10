package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.SKILL_TALENT_TABLE

@Entity(tableName = SKILL_TALENT_TABLE)
data class SkillTalent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var description: String,
    var name: String,
    var type: String,
    var unlock: String,
    var character_id: Int
)
