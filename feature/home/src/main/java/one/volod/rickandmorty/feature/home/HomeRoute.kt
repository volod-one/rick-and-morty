package one.volod.rickandmorty.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object Home

fun NavGraphBuilder.toHomeScreen(onCharacterSelected: (Int) -> Unit) {
    composable<Home> {
        HomeScreen(onCharacterSelected = onCharacterSelected)
    }
}
