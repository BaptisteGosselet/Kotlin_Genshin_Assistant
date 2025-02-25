package com.example.genshinassistant.data.repository

import com.example.genshinassistant.data.dao.CharacterDao
import com.example.genshinassistant.data.dao.ConstellationDao
import com.example.genshinassistant.data.dao.PassiveTalentDao
import com.example.genshinassistant.data.dao.SkillTalentDao
import com.example.genshinassistant.data.dao.UpgradeDao
import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.model.Constellation
import com.example.genshinassistant.data.model.PassiveTalent
import com.example.genshinassistant.data.model.SkillTalent
import com.example.genshinassistant.data.model.Upgrade
import kotlinx.coroutines.flow.Flow

// Creer un nouveau type
typealias Characters = List<Character>

class CharacterRepository(private val characterDao: CharacterDao,
                          private val constellationDao: ConstellationDao,
                          private val PassiveTalentDao: PassiveTalentDao,
                          private val skillTalentDao: SkillTalentDao,
                          private val UpgradeDao: UpgradeDao ){

    fun getAllCharactersFromRoom(): Flow<Characters> {
        return characterDao.getCharacters()
    }

    fun getCharacterByNameFromRoom(nameId: String): Character {
        return characterDao.getCharacterByName(nameId)
    }

    suspend fun addCharacterToRoom(character: Character) : Long {
        return characterDao.addCharacter(character)
    }

    suspend fun deleteCharacterFromRoom(character: Character) {
        characterDao.deleteCharacter(character)
    }

    suspend fun deleteCharacterByNameIdFromRoom(nameId: String) {
        characterDao.deleteCharacterByNameId(nameId)
    }

    suspend fun addConstellationToRoom(constellation: Constellation) : Long {
        return constellationDao.addConstellation(constellation)
    }

    suspend fun addAllConstellationsToRoom(constellations: List<Constellation>) {
        constellationDao.addAllConstellations(constellations)
    }

    suspend fun deleteConstellationByNameIdFromRoom(nameId: String) {
        constellationDao.deleteConstellationByNameId(nameId)
    }

    suspend fun addPassiveTalentToRoom(passiveTalent: PassiveTalent) : Long {
        return PassiveTalentDao.addPassiveTalent(passiveTalent)
    }

    suspend fun addAllPassiveTalentsToRoom(passiveTalents: List<PassiveTalent>) {
        PassiveTalentDao.addAllPassiveTalents(passiveTalents)
    }

    suspend fun deletePassiveTalentByNameIdFromRoom(nameId: String) {
        PassiveTalentDao.deletePassiveTalentByNameId(nameId)
    }

    suspend fun addSkillTalentToRoom(skillTalent: SkillTalent) : Long {
        return skillTalentDao.addSkillTalent(skillTalent)
    }

    suspend fun addAllSkillTalentsToRoom(skillTalents: List<SkillTalent>) {
        skillTalentDao.addAllSkillTalents(skillTalents)
    }

    suspend fun deleteSkillTalentByNameIdFromRoom(nameId: String) {
        skillTalentDao.deleteSkillTalentByNameId(nameId)
    }

    suspend fun addUpgradeToRoom(upgrade: Upgrade) : Long {
        return UpgradeDao.addUpgrade(upgrade)
    }

    suspend fun addAllUpgradesToRoom(upgrades: List<Upgrade>) {
        UpgradeDao.addAllUpgrades(upgrades)
    }

    suspend fun deleteUpgradeBySkillTalentIdFromRoom(skillTalentId: Int) {
        UpgradeDao.deleteUpgradeBySkillTalentId(skillTalentId)
    }

}