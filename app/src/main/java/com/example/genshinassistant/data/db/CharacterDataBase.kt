package com.example.genshinassistant.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.genshinassistant.Utils.Companion.CHARACTER_DATABASE
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Character::class, Constellation::class, PassiveTalent::class, SkillTalent::class, Upgrade::class],
    version = 1
)
abstract class CharacterDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun constellationDao(): ConstellationDao
    abstract fun passiveTalentDao(): PassiveTalentDao
    abstract fun skillTalentDao(): SkillTalentDao
    abstract fun upgradeDao(): UpgradeDao

    companion object {
        @Volatile
        private var instance: CharacterDataBase? = null

        fun getDatabase(context: Context): CharacterDataBase {
            // Vider la BDD à chaque fois pour test
            if (context.deleteDatabase(CHARACTER_DATABASE)) Log.d("BDD", "RESET de la BDD OK") else Log.d("BDD", "RESET de la BDD PAS OK !!")

            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDataBase::class.java,
                    CHARACTER_DATABASE
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(CharacterDataBaseCallback())
                    .build()
            }
        }
    }

    // Callback to prepopulate the Database
    class CharacterDataBaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    val characterDao = database.characterDao()
                    characterDao.deleteAllCharacters()
                    val initialCharacters = listOf(
                        Character(0, "", "", "", "", "", "", "", 0, "", "", "", "", "")
                    )
                    characterDao.addCharacter(initialCharacters[0])
                    val constellationDao = database.constellationDao()
                    constellationDao.deleteAllConstellations()
                    val initialConstellation = listOf(
                        Constellation(0, "", 0, "", "", "")
                    )
                    constellationDao.addConstellation(initialConstellation[0])
                    val passiveTalentDao = database.passiveTalentDao()
                    passiveTalentDao.deleteAllPassiveTalents()
                    val initialPassiveTalents = listOf(
                        PassiveTalent(0, "", 0, "", "", "")
                    )
                    passiveTalentDao.addPassiveTalent(initialPassiveTalents[0])
                    val skillTalentDao = database.skillTalentDao()
                    skillTalentDao.deleteAllSkillTalents()
                    val initialSkillTalents = listOf(
                        SkillTalent(0, "", "", "", "", "")
                    )
                    skillTalentDao.addSkillTalent(initialSkillTalents[0])
                    val upgradeDao = database.upgradeDao()
                    upgradeDao.deleteAllUpgrades()
                    val initialUpgrades = listOf(
                        Upgrade(0, "", "", 0)
                    )
                    upgradeDao.addUpgrade(initialUpgrades[0])
                }
            }
        }

    }
}


