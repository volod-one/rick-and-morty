package one.volod.rickandmorty.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import one.volod.rickandmorty.feature.character_details.CharacterDetails
import one.volod.rickandmorty.feature.character_details.toCharacterDetailsScreen
import one.volod.rickandmorty.feature.characters_episode.CharacterEpisode
import one.volod.rickandmorty.feature.characters_episode.toCharactersEpisodeScreen
import one.volod.rickandmorty.feature.home.Home
import one.volod.rickandmorty.feature.home.toHomeScreen

@Composable
internal fun Navigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Column {
                Text(text = "test")
            }
        }
//        toHomeScreen(
//            onCharacterSelected = { characterId ->
//                navController.navigate(CharacterDetails(characterId = characterId))
//            }
//        )
//
//        toCharacterDetailsScreen(
//            onEpisodeClicked = { characterId ->
//                navController.navigate(CharacterEpisode(characterId = characterId))
//            }
//        )
//
//        toCharactersEpisodeScreen()
    }
}
