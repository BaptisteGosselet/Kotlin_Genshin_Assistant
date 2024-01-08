package com.example.genshinassistant.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.CHARACTER_TABLE

@Entity(tableName = CHARACTER_TABLE)
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nameId: String,
    var affiliation: String,
    var birthday: String,
    var constellation: String,
    var description: String,
    var name: String,
    var nation: String,
    var rarity: Int,
    var title: String,
    var vision: String,
    var vision_key: String,
    var weapon: String,
    var weapon_type: String
)
