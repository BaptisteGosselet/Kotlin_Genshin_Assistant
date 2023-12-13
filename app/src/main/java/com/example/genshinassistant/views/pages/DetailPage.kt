package com.example.genshinassistant.views


import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.CharacterListViewModel
import com.example.genshinassistant.viewModels.DetailViewModel

@Composable
fun DetailPage(nameId:String) {
    Log.d("bapt", "detailpage")

    val vm = DetailViewModel(nameId);

    Column {
        Text(text="Detail");
        Text(text = vm.character.value?.name.toString())
        Text(text = vm.character.value?.vision.toString())
    }

}

