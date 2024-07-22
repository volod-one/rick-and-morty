import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetails(
    val characterId: Int,
)

fun NavGraphBuilder.toCharacterDetailsScreen(
//    onEpisodeClicked: (Int) -> Unit
) {
    composable(route = CharacterDetails.toString()) {
//        val args = it.toRoute<CharacterDetails>()
        CharacterDetailsScreen(
//            characterId = args.characterId,
//            onEpisodeClicked = onEpisodeClicked
        )
    }
}