package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.PASSIVE_TALENT_TABLE

@Entity(tableName = PASSIVE_TALENT_TABLE)
data class PassiveTalent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String,
    val character_id: Int
)
