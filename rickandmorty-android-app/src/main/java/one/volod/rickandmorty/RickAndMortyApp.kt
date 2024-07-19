package one.volod.rickandmorty

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import one.volod.rickandmorty.navigation.Navigation
import one.volod.ui.common.components.theme.RickandmortyTheme

@Composable
internal fun RickAndMortyApp() {
    RickandmortyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation()
        }
    }
}
