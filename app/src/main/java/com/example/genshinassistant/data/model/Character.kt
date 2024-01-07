package com.example.genshinassistant.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.genshinassistant.Utils.Companion.CHARACTER_TABLE

@Entity(tableName = CHARACTER_TABLE)
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val affiliation: String,
    val birthday: String,
    val constellation: String,
    // Liste des id des constellations
    //val constellations: List<Int>,
    val description: String,
    val name: String,
    val nation: String,
    // Liste des id des passives talents
    //val passiveTalents: List<Int>,
    val rarity: Int,
    // Liste des id des skills talents
    //val skillTalents: List<Int>,
    val title: String,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String
)
