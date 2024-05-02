package one.volod.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import one.volod.core.network.KtorClient
import one.volod.rickandmorty.screens.CharacterDetailsScreen
import one.volod.rickandmorty.ui.theme.RickandmortyTheme

class MainActivity : ComponentActivity() {

    private val ktorClient = KtorClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            RickandmortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "character_details") {
                        composable("character_details") {
                            CharacterDetailsScreen(
                                ktorClient = ktorClient,
                                characterId = 1,
                                onEpisodeClicked = { character ->
                                    navController.navigate("character_episodes/$character")
                                }
                            )
                        }
                        composable(
                            route = "character_episodes/{characterId}",
                            arguments = listOf(
                                navArgument("characterId") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val characterId = backStackEntry.arguments?.getInt("characterId") ?: -1
                            CharacterEpisodeScreen(characterId = characterId)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterEpisodeScreen(characterId: Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Character episode screen: $characterId", fontSize = 28.sp)
    }
}
