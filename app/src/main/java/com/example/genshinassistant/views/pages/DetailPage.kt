package com.example.genshinassistant.views


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.DetailViewModel


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
                        modifier = Modifier.size(50.dp).offset(x = (-3).dp, y = 0.dp)
                    )
                    Box(modifier = Modifier.size(10.dp)){}
                    AsyncImage(
                        model = "https://api.genshin.dev/nations/${vm.character.value?.nation?.lowercase()}/icon",
                        contentDescription = "${vm.character.value?.nation.toString()}",
                        modifier = Modifier.size(65.dp).offset(x = (-10).dp, y = 0.dp)
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

                        Text(
                            text = vm.character.value?.title.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#6F6972")).copy(alpha = 0.75f)
                        )
                        Text(text = vm.character.value?.rarity.toString())
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

