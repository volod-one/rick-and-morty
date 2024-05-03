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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.volod.core.network.ApiOperation
import one.volod.core.network.KtorClient
import one.volod.core.network.models.domain.Character
import one.volod.rickandmorty.components.character.CharacterDetailsNamePlateComponent
import one.volod.rickandmorty.components.common.CharacterImage
import one.volod.rickandmorty.components.common.DataPoint
import one.volod.rickandmorty.components.common.DataPointComponent
import one.volod.rickandmorty.components.common.LoadingState
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {

    suspend fun fetchCharacter(characterId: Int): ApiOperation<Character> =
        ktorClient.getCharacter(characterId)
}

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
) : ViewModel() {

    private val _internalStorageFlow = MutableStateFlow<CharacterDetailsViewState>(
        value = CharacterDetailsViewState.Loading
    )
    val stateFlow = _internalStorageFlow.asStateFlow()

    fun fetchCharacter(characterId: Int) = viewModelScope.launch {
        _internalStorageFlow.update { return@update CharacterDetailsViewState.Loading }
        characterRepository.fetchCharacter(characterId).onSuccess { character ->
            val dataPoints = buildList {
                add(DataPoint(title = "Last known location", description = character.location.name))
                add(DataPoint(title = "Species", description = character.species))
                add(DataPoint(title = "Gender", description = character.gender.displayName))
                character.type.takeIf { it.isNotEmpty() }?.let { type ->
                    add(DataPoint(title = "Type", description = type))
                }
                add(DataPoint(title = "Origin", description = character.origin.name))
                add(
                    DataPoint(
                        title = "Episode count",
                        description = character.episodeIds.size.toString()
                    )
                )
            }
            _internalStorageFlow.update {
                return@update CharacterDetailsViewState.Success(
                    character = character,
                    characterDataPoints = dataPoints
                )
            }
        }.onFailure { exception ->
            _internalStorageFlow.update {
                return@update CharacterDetailsViewState.Error(
                    message = exception.message ?: "Unknown error"
                )
            }
        }
    }
}

sealed interface CharacterDetailsViewState {
    data object Loading : CharacterDetailsViewState
    data class Error(val message: String) : CharacterDetailsViewState
    data class Success(
        val character: Character,
        val characterDataPoints: List<DataPoint>,
    ) : CharacterDetailsViewState
}

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
