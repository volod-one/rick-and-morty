package one.volod.rickandmorty.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import one.volod.rickandmorty.components.character.CharacterDetailsNamePlateComponent
import one.volod.rickandmorty.components.common.CharacterImage
import one.volod.rickandmorty.components.common.DataPointComponent
import one.volod.rickandmorty.components.common.LoadingState
import one.volod.rickandmorty.viewmodel.CharacterDetailsViewModel
import one.volod.rickandmorty.viewmodel.CharacterDetailsViewState

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
    onEpisodeClicked: (Int) -> Unit,
) {
    LaunchedEffect(key1 = Unit) { viewModel.fetchCharacter(characterId) }

    val state by viewModel.stateFlow.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        when (val viewState = state) {
            CharacterDetailsViewState.Loading -> {
                item { LoadingState() }
                return@LazyColumn
            }

            is CharacterDetailsViewState.Error -> {}
            is CharacterDetailsViewState.Success -> {
                val character = viewState.character

                // Name plate
                item {
                    CharacterDetailsNamePlateComponent(
                        name = character.name,
                        status = character.status,
                    )
                }

                item { Spacer(modifier = Modifier.height(8.dp)) }

                // Image
                item {
                    CharacterImage(imageUrl = character.imageUrl)
                }

                // Data points
                items(viewState.characterDataPoints) {
                    Spacer(modifier = Modifier.height(32.dp))
                    DataPointComponent(dataPoint = it)
                }

                item { Spacer(modifier = Modifier.height(32.dp)) }

                // Button
                item {
                    Text(
                        text = "View all episodes",
                        color = Color.Cyan, // RickAction
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Color.Cyan, // RickAction
                                shape = RoundedCornerShape(12.dp),
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .clickable {
                                onEpisodeClicked(characterId)
                            }
                            .padding(vertical = 8.dp),
                    )
                }

                item { Spacer(modifier = Modifier.height(64.dp)) }
            }
        }
    }
}
