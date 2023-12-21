package com.example.genshinassistant.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.DetailViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun DetailPage(nameId:String) {

    val vm: DetailViewModel = remember { DetailViewModel(nameId) }

    Image(
        painter = painterResource(id = R.drawable.bg_details),
        contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )


    Column (
        modifier = Modifier
            .fillMaxSize()
    ){

        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(425.dp),
                horizontalAlignment = Alignment.End
            ) {

                Column {
                    Box(modifier = Modifier.size(10.dp)){}
                    AsyncImage(
                        model = "https://api.genshin.dev/elements/${vm.character.value?.vision?.lowercase()}/icon",
                        contentDescription = "${vm.character.value?.vision.toString()}",
                        modifier = Modifier
                            .size(50.dp)
                            .offset(x = (-3).dp, y = 0.dp)
                    )
                    Box(modifier = Modifier.size(10.dp)){}
                    AsyncImage(
                        model = "https://api.genshin.dev/nations/${vm.character.value?.nation?.lowercase()}/icon",
                        contentDescription = "${vm.character.value?.nation.toString()}",
                        modifier = Modifier
                            .size(65.dp)
                            .offset(x = (-10).dp, y = 0.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ){
                        Icon(
                            painter = painterResource(R.drawable.bookmark_add),
                            contentDescription = "Favorites",
                            tint = Color.White,
                            modifier = Modifier
                                .size(45.dp)
                                .offset(x = 5.dp, y = (-5).dp)
                                .clickable { vm.addToFavorite(nameId) }
                        )
                    }
                }
        }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .clip(RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp))
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(android.graphics.Color.parseColor("#FEFFF1")))
                ) {

                    Column(
                        modifier = Modifier.padding(25.dp, 35.dp, 20.dp, 20.dp)
                    ){
                        Text(
                            text = vm.character.value?.name.toString(),
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#6F6972")),
                        )

                        Text(text = vm.character.value?.title.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#6F6972")).copy(alpha = 0.75f),
                            )

                        Row {
                            for(i in 1..(vm.character.value?.rarity ?: 0)){
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_star_24),
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "Star",
                                    contentScale = ContentScale.Crop,
                                    )
                                }
                            }

                        Box(modifier = Modifier.size(10.dp)){}
                        Text(text = vm.character.value?.description.toString())
                    }

                }

            }
        }
    }

    AsyncImage(
        model = "https://api.genshin.dev/characters/$nameId/portrait",
        contentDescription = "",
        modifier = Modifier
            .height(485.dp)
            .offset(x = 0.dp, y = 10.dp)
    )

}

