package com.example.genshinassistant.views.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.genshinassistant.navigation.RouteNames

@Composable
fun CharacterCardGridView(nameId:String, name:String, vision:String, navController:NavController) {



    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .size(130.dp, 170.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    Log.d("bapt", RouteNames.details + "/$nameId")
                    navController.navigate(RouteNames.details + "/$nameId") {
                        popUpTo(RouteNames.grid)
                    }
                }
        ) {

            val bgColor:String = when (vision) {
                "Anemo"     -> "#3FD3DC"
                "Geo"       -> "#DCA73F"
                "Pyro"      -> "#DC6E3F"
                "Cryo"      -> "#3FD3DC"
                "Hydro"     -> "#3F4FDC"
                "Electro"   -> "#7B3FDC"
                "Dendro"    -> "#92ef66"
                else        -> "#FEFFF1"
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(color = Color(android.graphics.Color.parseColor(bgColor)).copy(alpha = 0.7f) )
            ) {

                AsyncImage(
                    model = "https://api.genshin.dev/characters/${nameId}/icon-big",
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )

                AsyncImage(
                    model = "https://api.genshin.dev/elements/${vision.lowercase()}/icon",
                    contentDescription = "",
                    modifier = Modifier
                        .height(35.dp)
                        .align(Alignment.TopEnd)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = Color(android.graphics.Color.parseColor("#FEFFF1")))
            ) {
                Text(
                    text = name,
                    color = Color(android.graphics.Color.parseColor("#6F6972")),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}

