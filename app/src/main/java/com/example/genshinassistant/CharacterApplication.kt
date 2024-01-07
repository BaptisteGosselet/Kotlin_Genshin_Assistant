package com.example.genshinassistant

import android.app.Application
import com.example.genshinassistant.data.dao.CharacterDao
import com.example.genshinassistant.data.db.CharacterDataBase
import com.example.genshinassistant.data.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CharacterApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: CharacterDataBase by lazy { CharacterDataBase.getDatabase(this) }
    val characterDao: CharacterDao by lazy { database.characterDao() }
    val repository: CharacterRepository by lazy { CharacterRepository(characterDao) }
}