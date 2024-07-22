package one.volod.rickandmorty.feature.home

import HomeScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object Home

fun NavGraphBuilder.toHomeScreen(
    onGoToScreen2Click: () -> Unit,
    onGoToScreen3Click: () -> Unit,
//    onCharacterSelected: (Int) -> Unit
) {
    composable(route = Home.toString()) {
        HomeScreen(
//            onCharacterSelected = onCharacterSelected
            onGoToScreen2Click = onGoToScreen2Click,
            onGoToScreen3Click = onGoToScreen3Click,
        )
    }
}
