package navigation

import CharacterDetails
import CharacterEpisode
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.volod.rickandmorty.feature.home.Home
import one.volod.rickandmorty.feature.home.toHomeScreen
import toCharacterDetailsScreen
import toCharacterEpisodeScreen

@Composable
internal fun Navigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Home.toString()) {
        toHomeScreen(
            onGoToScreen2Click = {
                navController.navigate(route = CharacterDetails.toString())

            },
            onGoToScreen3Click = {
                navController.navigate(route = CharacterEpisode.toString())
            }
//            onCharacterSelected = { characterId ->
//                navController.navigate(CharacterDetails(characterId = characterId).toString())
//            }
        )

        toCharacterDetailsScreen(
//            onEpisodeClicked = { characterId ->
//                navController.navigate(CharacterEpisode(characterId = characterId).toString())
//            }
        )

        toCharacterEpisodeScreen()
    }
}
