package com.example.genshinassistant.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.genshinassistant.viewModels.CharacterListViewModel

@Composable
fun GridList() {


    val vm = CharacterListViewModel();

    Column (modifier = Modifier.fillMaxHeight()){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 20.dp,
                end = 16.dp,
                bottom = 20.dp)
        ){
            items(vm.characters.value){
                    character ->
                CharacterCard(
                    nameId = character.nameId.toString(),
                    name = character.name.toString(),
                    vision = character.vision.toString())
            }
        }
    }
}

