package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.UPGRADE_TABLE

@Entity(tableName = UPGRADE_TABLE)
data class Upgrade(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val value: String,
    val skillTalent_id: Int
)
