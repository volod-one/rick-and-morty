import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class CharacterEpisode(
    val characterId: Int,
)

fun NavGraphBuilder.toCharacterEpisodeScreen() {
    composable(route = CharacterEpisode.toString()) {
//        val args = it.toRoute<CharacterEpisode>()
        CharacterEpisodeScreen(
//            characterId = args.characterId,
        )
    }
}
