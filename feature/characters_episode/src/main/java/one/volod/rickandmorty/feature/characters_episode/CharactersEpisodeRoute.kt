package one.volod.rickandmorty.feature.characters_episode


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class CharacterEpisode(
    val characterId: Int,
)

fun NavGraphBuilder.toCharactersEpisodeScreen() {
    composable<CharacterEpisode> {
        val args = it.toRoute<CharacterEpisode>()
        CharacterEpisodeScreen(
            characterId = args.characterId,
        )
    }
}
