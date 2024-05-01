package one.volod.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import one.volod.core.network.KtorClient
import one.volod.rickandmorty.screens.CharacterDetailsScreen
import one.volod.rickandmorty.ui.theme.RickandmortyTheme

class MainActivity : ComponentActivity() {

    private val ktorClient = KtorClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickandmortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CharacterDetailsScreen(
                        ktorClient = ktorClient,
                        characterId = 1
                    )
                }
            }
        }
    }
}
