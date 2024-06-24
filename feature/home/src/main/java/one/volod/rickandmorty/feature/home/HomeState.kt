package one.volod.rickandmorty.feature.home

import one.volod.rickandmodry.core.models.domain.Character

sealed interface HomeScreenViewState {
    data object Loading : HomeScreenViewState
    data class GridDisplay(
        val characters: List<Character> = emptyList()
    ) : HomeScreenViewState

    data class Error(val message: String) : HomeScreenViewState
}