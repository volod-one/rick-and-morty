//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//import one.volod.rickandmodry.core.models.domain.Character
//import one.volod.rickandmorty.core.domain.usecase.FetchCharacterUseCase
//import one.volod.ui.common.components.common.DataPoint
//import javax.inject.Inject
//
//sealed interface CharacterDetailsViewState {
//    data object Loading : CharacterDetailsViewState
//    data class Error(val message: String) : CharacterDetailsViewState
//    data class Success(
//        val character: Character,
//        val characterDataPoints: List<DataPoint>,
//    ) : CharacterDetailsViewState
//}
//
//@HiltViewModel
//class CharacterDetailsViewModel @Inject constructor(
//    private val fetchCharacterUseCase: FetchCharacterUseCase,
//) : ViewModel() {
//
//    private val _internalStorageFlow = MutableStateFlow<CharacterDetailsViewState>(
//        value = CharacterDetailsViewState.Loading
//    )
//    val stateFlow = _internalStorageFlow.asStateFlow()
//
//    fun fetchCharacter(characterId: Int) = viewModelScope.launch {
//        _internalStorageFlow.update { return@update CharacterDetailsViewState.Loading }
//        fetchCharacterUseCase(characterId).onSuccess { character ->
//            val dataPoints = buildList {
//                add(
//                    DataPoint(
//                        title = "Last known location",
//                        description = character.location.name
//                    )
//                )
//                add(
//                    DataPoint(
//                        title = "Species",
//                        description = character.species
//                    )
//                )
//                add(
//                    DataPoint(
//                        title = "Gender",
//                        description = character.gender.displayName
//                    )
//                )
//                character.type.takeIf { it.isNotEmpty() }?.let { type ->
//                    add(
//                        DataPoint(
//                            title = "Type",
//                            description = type
//                        )
//                    )
//                }
//                add(
//                    DataPoint(
//                        title = "Origin",
//                        description = character.origin.name
//                    )
//                )
//                add(
//                    DataPoint(
//                        title = "Episode count",
//                        description = character.episodeIds.size.toString()
//                    )
//                )
//            }
//            _internalStorageFlow.update {
//                return@update CharacterDetailsViewState.Success(
//                    character = character,
//                    characterDataPoints = dataPoints
//                )
//            }
//        }.onFailure { exception ->
//            _internalStorageFlow.update {
//                return@update CharacterDetailsViewState.Error(
//                    message = exception.message ?: "Unknown error"
//                )
//            }
//        }
//    }
//}
