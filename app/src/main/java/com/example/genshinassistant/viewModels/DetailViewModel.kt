package com.example.genshinassistant.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.CharacterApplication
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.repository.UseCase
import kotlinx.coroutines.launch

class DetailViewModel(nameId:String, characterRoomViewModel: CharacterRoomViewModel) : ViewModel() {

    val useCase = UseCase();
    var errorMessage: String by mutableStateOf("");

    val characterRoomViewModel = characterRoomViewModel;

    private var _character = mutableStateOf<Character?>(null);
    val character: State<Character?> = _character;

    init {
        loadCharacter(nameId);
    }

    private fun loadCharacter(nameId: String) {
        viewModelScope.launch {
            try {
                _character.value = useCase.getCharacterByName(nameId);
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    suspend fun addToFavorite(nameId: String){
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
        val i : Long = characterRoomViewModel.addCharacter(c)
        Log.d("bapt", "addToFavorite($c) + $i")
    }

}
