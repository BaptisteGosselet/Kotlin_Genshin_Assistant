package com.example.genshinassistant.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.CONSTELLATION_TABLE

@Entity(tableName = CONSTELLATION_TABLE)
data class Constellation(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var description: String,
    var level: Int,
    var name: String,
    var unlock: String,
    var nameId: String
)
