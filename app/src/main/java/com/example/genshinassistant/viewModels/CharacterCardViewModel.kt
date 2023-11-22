package com.example.genshinassistant.viewModels

import android.media.Image
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genshinassistant.models.Character
import com.example.genshinassistant.repository.APIService
import kotlinx.coroutines.launch
import java.lang.Exception

class CharacterCardViewModel(
    name:String
) : ViewModel() {

    var nameId:String="";

    //var characterIcon = mutableStateOf<Res?>(null);

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
               // characterIcon.value = apiService.getCharacterIcon(name);
               // Log.d("montag", characterIcon.value.toString());
            }
            catch (e: Exception){
                Log.d("montag", "ERREUR IMAGE");

                errorMessage = e.message.toString();
            }
        }
    }


}