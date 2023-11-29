package com.example.genshinassistant.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.service.APIService
import kotlinx.coroutines.launch
import java.lang.Exception

class CharacterCardViewModel(
    name:String
) : ViewModel() {

    var nameId:String="";

    lateinit var character:Character;
    var vision:String=""

    var errorMessage : String by mutableStateOf("");

    init{
        this.nameId = name;
        getCharacter(this.nameId);
    }


    private fun getCharacter(name: String) {
        viewModelScope.launch {
            val apiService = APIService.retrofitApiService;
            Log.d("montag", name)
            try {
                character = apiService.getCharacterByName(nameId);
                vision = character.vision
                Log.d("montag", "$nameId : $vision");
               // Log.d("montag", characterIcon.value.toString());
            }
            catch (e: Exception){
                Log.d("montag", e.message.toString());

                errorMessage = e.message.toString();
            }
        }
    }


}