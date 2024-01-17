package com.example.genshinassistant.views.pages


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.genshinassistant.R
import com.example.genshinassistant.viewModels.CharacterRoomViewModel
import com.example.genshinassistant.viewModels.DetailViewModel
import com.example.genshinassistant.views.DetailList
import com.example.genshinassistant.views.DetailListElement
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailPage(nameId:String, characterRoomViewModel: CharacterRoomViewModel) {

    val vm: DetailViewModel = remember { DetailViewModel(nameId, characterRoomViewModel) }
    val context = LocalContext.current

    val skillTalents = mutableListOf<DetailListElement>()
    if((vm.character.value?.skillTalents?.size ?: 0) > 0) skillTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-na",title = vm.character.value?.skillTalents?.get(0)?.name.toString(), description = vm.character.value?.skillTalents?.get(0)?.description.toString()))
    if((vm.character.value?.skillTalents?.size ?: 0) > 1) skillTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-skill",title = vm.character.value?.skillTalents?.get(1)?.name.toString(), description = vm.character.value?.skillTalents?.get(1)?.description.toString()))
    if((vm.character.value?.skillTalents?.size ?: 0) > 2) skillTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-burst",title = vm.character.value?.skillTalents?.get(2)?.name.toString(), description = vm.character.value?.skillTalents?.get(2)?.description.toString()))

    val passiveTalents = mutableListOf<DetailListElement>()
    if((vm.character.value?.passiveTalents?.size ?: 0) > 0) passiveTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-passive-0", title = vm.character.value?.passiveTalents?.get(0)?.name.toString(), description = vm.character.value?.passiveTalents?.get(0)?.description.toString()))
    if((vm.character.value?.passiveTalents?.size ?: 0) > 1) passiveTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-passive-1", title = vm.character.value?.passiveTalents?.get(1)?.name.toString(), description = vm.character.value?.passiveTalents?.get(1)?.description.toString()))
    if((vm.character.value?.passiveTalents?.size ?: 0) > 2) passiveTalents.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/talent-passive-2", title = vm.character.value?.passiveTalents?.get(2)?.name.toString(), description = vm.character.value?.passiveTalents?.get(2)?.description.toString()))

    val constellations = mutableListOf<DetailListElement>()
    if((vm.character.value?.constellations?.size ?: 0) > 0) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-1", title = vm.character.value?.constellations?.get(0)?.name.toString(), description = vm.character.value?.constellations?.get(0)?.description.toString()))
    if((vm.character.value?.constellations?.size ?: 0) > 1) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-2", title = vm.character.value?.constellations?.get(1)?.name.toString(), description = vm.character.value?.constellations?.get(1)?.description.toString()))
    if((vm.character.value?.constellations?.size ?: 0) > 2) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-3", title = vm.character.value?.constellations?.get(2)?.name.toString(), description = vm.character.value?.constellations?.get(2)?.description.toString()))
    if((vm.character.value?.constellations?.size ?: 0) > 3) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-4", title = vm.character.value?.constellations?.get(3)?.name.toString(), description = vm.character.value?.constellations?.get(3)?.description.toString()))
    if((vm.character.value?.constellations?.size ?: 0) > 4) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-5", title = vm.character.value?.constellations?.get(4)?.name.toString(), description = vm.character.value?.constellations?.get(4)?.description.toString()))
    if((vm.character.value?.constellations?.size ?: 0) > 5) constellations.add(DetailListElement(iconUrl = "https://api.genshin.dev/characters/$nameId/constellation-6", title = vm.character.value?.constellations?.get(5)?.name.toString(), description = vm.character.value?.constellations?.get(5)?.description.toString()))


    Image(
        painter = painterResource(id = R.drawable.bg_details),
        contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    val pagerState = rememberPagerState(pageCount = {
        4
    })
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPager(state = pagerState) { page ->

            if (page == 0) {

                Box {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {

                        Column {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(425.dp),
                                horizontalAlignment = Alignment.End
                            ) {

                                Column {
                                    Box(modifier = Modifier.size(10.dp)) {}
                                    AsyncImage(
                                        model = "https://api.genshin.dev/elements/${vm.character.value?.vision?.lowercase()}/icon",
                                        contentDescription = vm.character.value?.vision.toString(),
                                        modifier = Modifier
                                            .size(50.dp)
                                            .offset(x = (-3).dp, y = 0.dp)
                                    )
                                    Box(modifier = Modifier.size(10.dp)) {}
                                    AsyncImage(
                                        model = "https://api.genshin.dev/nations/${vm.character.value?.nation?.lowercase()}/icon",
                                        contentDescription = vm.character.value?.nation.toString(),
                                        modifier = Modifier
                                            .size(65.dp)
                                            .offset(x = (-10).dp, y = 0.dp)
                                    )

                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.Bottom
                                    ) {
                                        val scope = rememberCoroutineScope()
                                        if(vm.isFavorite.value){
                                            Icon(
                                                painter = painterResource(id = R.drawable.bookmark_added),
                                                contentDescription = "Favorites",
                                                tint = Color(android.graphics.Color.parseColor("#1AA7CE")),
                                                modifier = Modifier
                                                    .size(45.dp)
                                                    .offset(x = 5.dp, y = (-5).dp)
                                                    .clickable {
                                                        scope.launch {
                                                            vm.deleteFromFavorite()
                                                            favoriteMessage(
                                                                nameId,
                                                                !vm.isFavorite.value,
                                                                context
                                                            )

                                                        }
                                                    }
                                            )
                                        }
                                        else{
                                            Icon(
                                                painter = painterResource(id = R.drawable.bookmark_add),
                                                contentDescription = "Favorites",
                                                tint = Color(android.graphics.Color.parseColor("#FFFFFF")),
                                                modifier = Modifier
                                                    .size(45.dp)
                                                    .offset(x = 5.dp, y = (-5).dp)
                                                    .clickable {
                                                        scope.launch {
                                                            vm.addToFavorite(nameId)
                                                            favoriteMessage(
                                                                nameId,
                                                                !vm.isFavorite.value,
                                                                context
                                                            )

                                                        }
                                                    }
                                            )
                                        }
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
                                        .verticalScroll(rememberScrollState())
                                        .weight(weight = 1f, fill = false)
                                ) {

                                    Column(
                                        modifier = Modifier.padding(25.dp, 35.dp, 20.dp, 20.dp)
                                    ) {
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
                                            color = Color(android.graphics.Color.parseColor("#6F6972")).copy(
                                                alpha = 0.75f
                                            ),
                                        )

                                        Row {
                                            for (i in 1..(vm.character.value?.rarity ?: 0)) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.baseline_star_24),
                                                    modifier = Modifier.size(24.dp),
                                                    contentDescription = "Star",
                                                    contentScale = ContentScale.Crop,
                                                )
                                            }
                                        }

                                        Box(modifier = Modifier.size(10.dp)) {}
                                        Text(text = vm.character.value?.description.toString(), color = Color(android.graphics.Color.parseColor("#6F6972")))
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
            }
            if(page == 1){
                DetailList("Skill Talents", skillTalents)
            }
            if(page == 2){
                DetailList(pageTitle = "Passive Talents", elements = passiveTalents)
            }
            if(page == 3){
                DetailList("Constellations", constellations)
            }

        }
    }
    }


fun favoriteMessage(nameId: String, state:Boolean, context : Context) {
    if (state)
        Toast.makeText(context, "Character $nameId removed from favorites", Toast.LENGTH_SHORT).show()
    else
        Toast.makeText(context, "Character $nameId added to favorites", Toast.LENGTH_SHORT).show()
}
