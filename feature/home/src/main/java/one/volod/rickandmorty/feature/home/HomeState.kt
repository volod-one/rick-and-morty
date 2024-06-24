package one.volod.rickandmorty.feature.home

import one.volod.rickandmorty.core.domain.models.domain.Character

sealed interface HomeScreenViewState {
    data object Loading : HomeScreenViewState
    data class GridDisplay(
        val characters: List<Character> = emptyList()
    ) : HomeScreenViewState

    data class Error(val message: String) : HomeScreenViewState
}