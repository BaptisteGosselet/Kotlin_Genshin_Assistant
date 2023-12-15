package com.example.genshinassistant.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import com.example.genshinassistant.R

class IconResource private constructor(
    @DrawableRes private val resID: Int?,
    private val imageVector: ImageVector?
) {

    @Composable
    fun asPainterResource(): Painter {
        resID?.let {
            return painterResource(id = resID)
        }
        return rememberVectorPainter(image = imageVector!!)
    }

    companion object {
        fun fromDrawableResource(@DrawableRes resID: Int): IconResource {
            return IconResource(resID, null)
        }

        fun fromImageVector(imageVector: ImageVector?): IconResource {
            return IconResource(null, imageVector)
        }
    }
}
sealed class NavigationItem (val label: String, val icon: IconResource){
    object Grid : NavigationItem("Grid",
        IconResource.fromDrawableResource(R.drawable.baseline_grid_view)
    )
    object List : NavigationItem("List", IconResource.fromImageVector(Icons.Filled.List))
    object Favorites : NavigationItem("Favorites",
        IconResource.fromImageVector(Icons.Filled.Favorite)
    )
}
