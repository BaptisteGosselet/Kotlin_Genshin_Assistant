package com.example.genshinassistant.views

import androidx.compose.foundation.background
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
import coil.compose.AsyncImage
import com.example.genshinassistant.viewModels.CharacterCardViewModel

@Composable
fun CharacterCard(viewModel: CharacterCardViewModel) {

    Box(modifier = Modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .size(130.dp, 170.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {

                AsyncImage(
                    model = "https://api.genshin.dev/characters/${viewModel.nameId}/icon-big",
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )



                AsyncImage(
                    //model = "https://api.genshin.dev/elements/${viewModel.vision}/icon",
                    model = "https://api.genshin.dev/elements/${viewModel.vision}/icon",
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
                // Texte centré dans la zone rouge avec Signika Bold
                Text(
                    text = viewModel.nameId,
                    color = Color(android.graphics.Color.parseColor("#6F6972")),
                    fontSize = 16.sp,
                    //fontFamily = FontFamily(Font(R.font)), //Signika
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

