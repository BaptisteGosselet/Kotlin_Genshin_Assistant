package com.example.genshinassistant.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.CharacterListViewModel
@Composable
fun GridList() {


    val vm = CharacterListViewModel();


    Image(
        painter = painterResource(id = R.drawable.bg_list),
        contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 30.dp,
                top = 20.dp,
                end = 0.dp,
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

