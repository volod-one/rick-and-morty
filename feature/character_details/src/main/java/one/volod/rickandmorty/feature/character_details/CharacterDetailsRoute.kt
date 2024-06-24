package one.volod.rickandmorty.feature.character_details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetails(
    val characterId: Int,
)

fun NavGraphBuilder.toCharacterDetailsScreen(onEpisodeClicked: (Int) -> Unit) {
    composable<CharacterDetails> {
        val args = it.toRoute<CharacterDetails>()
        CharacterDetailsScreen(
            characterId = args.characterId,
            onEpisodeClicked = onEpisodeClicked
        )
    }
}