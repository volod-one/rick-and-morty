package one.volod.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import one.volod.core.network.KtorClient
import one.volod.rickandmorty.feature.character_details.CharacterDetails
import one.volod.rickandmorty.feature.character_details.toCharacterDetailsScreen
import one.volod.rickandmorty.feature.characters_episode.CharacterEpisode
import one.volod.rickandmorty.feature.characters_episode.toCharactersEpisodeScreen
import one.volod.rickandmorty.feature.home.Home
import one.volod.rickandmorty.feature.home.toHomeScreen
import one.volod.ui.common.components.theme.RickandmortyTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var ktorClient: KtorClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            RickandmortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = Home) {
                        toHomeScreen(onCharacterSelected = { characterId ->
                            navController.navigate(CharacterDetails(characterId = characterId))
                        })

                        toCharacterDetailsScreen(
                            onEpisodeClicked = { characterId ->
                                navController.navigate(CharacterEpisode(characterId = characterId))
                            }
                        )

                        toCharactersEpisodeScreen(ktorClient = ktorClient)
                    }
                }
            }
        }
    }
}
