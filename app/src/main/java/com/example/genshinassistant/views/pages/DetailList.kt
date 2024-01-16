package com.example.genshinassistant.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class DetailListElement(iconUrl : String, title : String, description : String){
    val iconUrl = iconUrl;
    val title = title;
    val description = description;
}

@Composable
fun DetailList(pageTitle:String, elements: List<DetailListElement>) {

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {

        Text(
            text = pageTitle,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#FEFFF1"))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 20.dp, 20.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            for (element in elements) {

                Box(
                    modifier = Modifier
                        .size(300.dp, 200.dp)
                        .padding(0.dp, 0.dp, 0.dp, 16.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color(android.graphics.Color.parseColor("#FEFFF1")))
                )
                {

                    Column {

                        Row(modifier = Modifier.padding(20.dp, 20.dp, 10.dp, 10.dp)) {

                            AsyncImage(
                                model = element.iconUrl,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(50.dp)
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            Text(
                                text = element.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#6F6972"))
                            )

                        }

                        Box(modifier = Modifier.padding(20.dp, 20.dp, 10.dp, 10.dp).verticalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = element.description,
                                fontSize = 12.sp,
                                color = Color(android.graphics.Color.parseColor("#6F6972")),
                                lineHeight = 15.sp
                            )
                        }
                    }
                }

            }

        }
    }

}
