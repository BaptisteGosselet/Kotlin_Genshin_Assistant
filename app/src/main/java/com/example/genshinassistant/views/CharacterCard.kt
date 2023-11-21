package com.example.genshinassistant.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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

@Composable
fun CharacterCard() {
    Box(
        modifier = Modifier
            .size(130.dp, 170.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(android.graphics.Color.parseColor("#FEFFF1")))
    ) {
        // Section bleue en haut
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(androidx.compose.ui.graphics.Color.Green)
        )

        // Section rouge en bas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .align(Alignment.BottomStart)
        ) {
            // Texte centré dans la zone rouge avec Signika Bold
            Text(
                text = "Kazuha",
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

