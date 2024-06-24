package one.volod.rickandmorty.core.domain.usecase

import one.volod.core.network.ApiOperation
import one.volod.rickandmodry.core.models.domain.Character
import one.volod.rickandmorty.core.repository.CharacterRepository
import javax.inject.Inject

class FetchCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
) {

    suspend operator fun invoke(characterId: Int): ApiOperation<Character> =
        characterRepository.fetchCharacter(characterId = characterId)
}
