package com.example.genshinassistant.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.repository.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(nameId:String, characterRoomViewModel: CharacterRoomViewModel) : ViewModel() {

    val useCase = UseCase();
    var errorMessage: String by mutableStateOf("");

    val characterRoomViewModel = characterRoomViewModel;

    private var _character = mutableStateOf<Character?>(null);
    val character: State<Character?> = _character;

    private var _isFavorite = mutableStateOf<Boolean>(false);
    val isFavorite: State<Boolean> = _isFavorite;


    init {
        loadCharacter(nameId);
    }

    private fun loadCharacter(nameId: String) {
        viewModelScope.launch {
            try {
                _character.value = useCase.getCharacterByName(nameId);
                _isFavorite.value = characterAlreadyInFavorite(nameId)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    suspend fun addToFavorite(nameId: String):Boolean{
        if (characterAlreadyInFavorite(nameId)) {
            return false
        }

        characterRoomViewModel.character.nameId = nameId
        characterRoomViewModel.character.affiliation = character.value?.affiliation.toString()
        characterRoomViewModel.character.birthday = character.value?.birthday.toString()
        characterRoomViewModel.character.constellation = character.value?.constellation.toString()
        characterRoomViewModel.character.description = character.value?.description.toString()
        characterRoomViewModel.character.name = character.value?.name.toString()
        characterRoomViewModel.character.nation = character.value?.nation.toString()
        characterRoomViewModel.character.rarity = character.value?.rarity.toString().toInt()
        characterRoomViewModel.character.title = character.value?.title.toString()
        characterRoomViewModel.character.vision = character.value?.vision.toString()
        characterRoomViewModel.character.vision_key = character.value?.vision_key.toString()
        characterRoomViewModel.character.weapon = character.value?.weapon.toString()
        characterRoomViewModel.character.weapon_type = character.value?.weapon_type.toString()

        val c = characterRoomViewModel.character

        val constellations = character.value?.constellations
        for (constellation in constellations!!) {
            characterRoomViewModel.constellation.description = constellation.description.toString()
            characterRoomViewModel.constellation.level = constellation.level?.toInt()!!
            characterRoomViewModel.constellation.name = constellation.name.toString()
            characterRoomViewModel.constellation.unlock = constellation.unlock.toString()
            characterRoomViewModel.constellation.nameId = nameId
            characterRoomViewModel.addConstellation(characterRoomViewModel.constellation)
        }

        val passiveTalents = character.value?.passiveTalents
        for (passiveTalent in passiveTalents!!) {
            characterRoomViewModel.passiveTalent.description = passiveTalent.description.toString()
            characterRoomViewModel.passiveTalent.level = passiveTalent.level?.toInt() ?: 0
            characterRoomViewModel.passiveTalent.name = passiveTalent.name.toString()
            characterRoomViewModel.passiveTalent.unlock = passiveTalent.unlock.toString()
            characterRoomViewModel.passiveTalent.nameId = nameId
            characterRoomViewModel.addPassiveTalent(characterRoomViewModel.passiveTalent)
        }

        val skillTalents = character.value?.skillTalents
        for (skillTalent in skillTalents!!) {
            characterRoomViewModel.skillTalent.description = skillTalent.description.toString()
            characterRoomViewModel.skillTalent.name = skillTalent.name.toString()
            characterRoomViewModel.skillTalent.type = skillTalent.type.toString()
            characterRoomViewModel.skillTalent.unlock = skillTalent.unlock.toString()
            characterRoomViewModel.skillTalent.nameId = nameId
        }

        return withContext(Dispatchers.IO) {
            try {
                characterRoomViewModel.addCharacter(c)
                _isFavorite.value = true
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    //  Delete a character from the database
    suspend fun deleteFromFavorite() {

        withContext(Dispatchers.IO) {
            characterRoomViewModel.deleteSkillTalentByCharacterId(characterRoomViewModel.character.nameId)
            characterRoomViewModel.deletePassiveTalentByCharacterId(characterRoomViewModel.character.nameId)
            characterRoomViewModel.deleteConstellationByCharacterId(characterRoomViewModel.character.nameId)
            characterRoomViewModel.deleteCharacterByNameId(characterRoomViewModel.character.nameId)
            _isFavorite.value = false
        }

        _isFavorite.value = false
    }

    private suspend fun characterAlreadyInFavorite(nameId: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val character = characterRoomViewModel.getCharacterByNameId(nameId)
                character != null
            } catch (e: Exception) {
                false
            }
        }
    }

}
