package com.example.genshinassistant

import android.app.Application
import com.example.genshinassistant.data.dao.CharacterDao
import com.example.genshinassistant.data.dao.ConstellationDao
import com.example.genshinassistant.data.dao.PassiveTalentDao
import com.example.genshinassistant.data.dao.SkillTalentDao
import com.example.genshinassistant.data.dao.UpgradeDao
import com.example.genshinassistant.data.db.CharacterDataBase
import com.example.genshinassistant.data.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CharacterApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: CharacterDataBase by lazy { CharacterDataBase.getDatabase(this) }
    val characterDao: CharacterDao by lazy { database.characterDao() }
    val constellationDao: ConstellationDao by lazy { database.constellationDao() }
    val passiveTalentDao: PassiveTalentDao by lazy { database.passiveTalentDao() }
    val skillTalentDao: SkillTalentDao by lazy { database.skillTalentDao() }
    val upgradeDao : UpgradeDao by lazy { database.upgradeDao() }
    val repository: CharacterRepository by lazy { CharacterRepository(characterDao, constellationDao, passiveTalentDao, skillTalentDao, upgradeDao) }
}