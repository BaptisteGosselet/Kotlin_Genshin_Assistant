package com.example.genshinassistant.views


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.genshinassistant.viewModels.DetailViewModel

@Composable
fun DetailPage(nameId:String) {

    val vm: DetailViewModel = remember { DetailViewModel(nameId) }

    Column {
        Text(text="Detail");
        Text(text=nameId);
        Text(text = vm.character.value?.name.toString())
        Text(text = vm.character.value?.vision.toString())
    }

}

