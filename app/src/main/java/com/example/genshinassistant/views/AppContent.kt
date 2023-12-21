import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.genshinassistant.navigation.RouteNames
import com.example.genshinassistant.viewModels.CharacterListViewModel
import com.example.genshinassistant.views.DetailPage
import com.example.genshinassistant.views.GridList
import com.example.genshinassistant.views.RowList
import com.example.genshinassistant.views.components.NavigationTopBar
import com.example.genshinassistant.views.pages.FavoritesScreen
import okhttp3.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navController: NavHostController, characterListViewModel: CharacterListViewModel) {
    Scaffold(
        topBar = {
            NavigationTopBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NavHost(navController = navController, startDestination = "grid") {
                composable(RouteNames.grid) {
                    GridList(characterListViewModel, navController)
                }
                composable(RouteNames.list) {
                    RowList(characterListViewModel, navController)
                }
                composable(RouteNames.favorites) {
                    FavoritesScreen()
                }
                composable(RouteNames.details + "/{nameId}", arguments = listOf(navArgument("nameId") { type = NavType.StringType })) { backStackEntry ->
                    DetailPage(nameId = backStackEntry.arguments?.getString("nameId").toString())
                }
            }
        }
    }
}