package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.UPGRADE_TABLE

@Entity(tableName = UPGRADE_TABLE)
data class Upgrade(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var value: String,
    var skillTalent_id: Int
)
