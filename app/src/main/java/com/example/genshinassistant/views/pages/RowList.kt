package com.example.genshinassistant.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.CharacterListViewModel
@Composable
fun RowList(viewModel: CharacterListViewModel) {

    Image(
        painter = painterResource(id = R.drawable.bg_list),
        contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(viewModel.characters.value){
                character ->
                CharacterCardRowView(
                    nameId = character.nameId.toString(),
                    name = character.name.toString(),
                    vision = character.vision.toString())
            }
        }

    }


