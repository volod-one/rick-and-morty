package one.volod.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.volod.core.network.models.domain.Character
import one.volod.rickandmorty.repositories.CharacterRepository
import javax.inject.Inject

sealed interface HomeScreenViewState {
    data object Loading : HomeScreenViewState
    data class GridDisplay(
        val characters: List<Character> = emptyList()
    ) : HomeScreenViewState

    data class Error(val message: String) : HomeScreenViewState
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow<HomeScreenViewState>(HomeScreenViewState.Loading)
    val viewState = _viewState.asStateFlow()

    fun fetchInitialPage() = viewModelScope.launch {
        val initialPage = repository.fetchCharacterPage(page = 1)
        initialPage.onSuccess { characterPage ->
            _viewState.update { return@update HomeScreenViewState.GridDisplay(characters = characterPage.characters) }
        }.onFailure {
            // TODO
        }
    }

    fun fetchNextPage() {
        // TODO
    }
}
