package com.example.genshinassistant.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.genshinassistant.Utils.Companion.CHARACTER_DATABASE
import com.example.genshinassistant.data.dao.CharacterDao
import com.example.genshinassistant.data.model.Character
import com.example.genshinassistant.data.model.Constellation
import com.example.genshinassistant.data.model.Upgrade
import com.example.genshinassistant.data.model.PassiveTalent
import com.example.genshinassistant.data.model.SkillTalent

@Database(
    entities = [Character::class, Constellation::class, PassiveTalent::class, SkillTalent::class, Upgrade::class],
    version = 1
)
abstract class CharacterDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

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
                ).build()
            }
        }
    }
}