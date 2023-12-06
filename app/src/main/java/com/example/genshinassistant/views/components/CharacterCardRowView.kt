package com.example.genshinassistant.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import coil.compose.AsyncImage

@Composable
fun CharacterCardRowView(nameId:String, name:String, vision:String) {

    Box(modifier = Modifier.padding(8.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(350.dp, 120.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    Log.d("chara", nameId)
                }
        ) {
            Box(modifier = Modifier.size(120.dp, 120.dp)) {
                var bgColor: String = when (vision) {
                    "Anemo" -> "#3FD3DC"
                    "Geo" -> "#DCA73F"
                    "Pyro" -> "#DC6E3F"
                    "Cryo" -> "#3FD3DC"
                    "Hydro" -> "#3F4FDC"
                    "Electro" -> "#7B3FDC"
                    "Dendro" -> "#92ef66"
                    else -> "#FEFFF1"
                };
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(android.graphics.Color.parseColor(bgColor)).copy(alpha = 0.7f))
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
                            .align(Alignment.BottomEnd)
                    )

                }
            }

            Box(
                modifier = Modifier
                    .background(color = Color(android.graphics.Color.parseColor("#FEFFF1")))
                ){
                Text(
                    text = name,
                    color = Color(android.graphics.Color.parseColor("#6F6972")),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize().wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }

    }

}
