package com.example.genshinassistant.views


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.genshinassistant.viewModels.CharacterListViewModel

@Composable
fun GridList() {


    val vm = CharacterListViewModel();

    LazyColumn(modifier = Modifier.fillMaxHeight()){
        items(vm.characters.value){
            character ->
            CharacterCard(
                nameId = character.nameId.toString(),
                name = character.name.toString(),
                vision = character.vision.toString())
        }
    }


    /*
    if(vm.isLoading.value){
       Column {
           Text(text = "Loading")
       }
    }
    else{
        LazyColumn(modifier = Modifier.fillMaxHeight()){
            items(characters.value){character ->
                Row {
                    Box(){
                        Text(text = character.name)

                    }
                }
            }
        }
    }
*/

    /*
    for (character in characters) {
        Log.d("grid", "${character.name} ${character.vision}")
    }
    */

    /*
    var vm_kazuha = CharacterCardViewModel("kazuha");
    var vm_tartaglia = CharacterCardViewModel("tartaglia");
    var vm_albedo = CharacterCardViewModel("albedo");

    Column {
        CharacterCard(vm_kazuha);
        CharacterCard(vm_tartaglia);
        CharacterCard(vm_albedo);
    }
    */
}

