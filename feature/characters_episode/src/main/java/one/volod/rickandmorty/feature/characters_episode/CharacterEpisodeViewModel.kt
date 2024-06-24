package one.volod.rickandmorty.feature.characters_episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.volod.rickandmodry.core.models.domain.Character
import one.volod.rickandmodry.core.models.domain.Episode
import one.volod.rickandmorty.core.domain.usecase.FetchCharacterUseCase
import one.volod.rickandmorty.core.domain.usecase.FetchEpisodesUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterEpisodeViewModel @Inject constructor(
    private val fetchEpisodesUseCase: FetchEpisodesUseCase,
    private val fetchCharacterUseCase: FetchCharacterUseCase,
) : ViewModel() {

    private var _character = MutableStateFlow<Character?>(null)
    val characterState = _character.asStateFlow()

    private var _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodesState = _episodes.asStateFlow()

    fun onLoadData(characterId: Int) {
        viewModelScope.launch {
            fetchCharacterUseCase(characterId)
                .onSuccess { character ->
                    _character.update { character }
                    launch {
                        fetchEpisodesUseCase(character.episodeIds)
                            .onSuccess { episodes ->
                                _episodes.update { episodes }
                            }.onFailure {
                                // TODO
                            }
                    }
                }.onFailure {
                    // TODO
                }
        }
    }

}
