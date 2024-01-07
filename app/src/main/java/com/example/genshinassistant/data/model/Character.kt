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
    val constellations: List<Constellation>,
    val description: String,
    val name: String,
    val nation: String,
    val passiveTalents: List<PassiveTalent>,
    val rarity: Int,
    val skillTalents: List<SkillTalent>,
    val title: String,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String
)
