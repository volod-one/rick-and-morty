package one.volod.rickandmorty.feature.characters_episode


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import one.volod.core.network.KtorClient

@Serializable
data class CharacterEpisode(
    val characterId: Int,
)

fun NavGraphBuilder.toCharactersEpisodeScreen(ktorClient: KtorClient) {
    composable<CharacterEpisode> {
        val args = it.toRoute<CharacterEpisode>()
        CharacterEpisodeScreen(
            characterId = args.characterId,
            ktorClient = ktorClient
        )
    }
}