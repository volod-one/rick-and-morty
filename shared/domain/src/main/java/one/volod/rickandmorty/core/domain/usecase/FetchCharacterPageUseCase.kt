package one.volod.rickandmorty.core.domain.usecase

import one.volod.core.network.ApiOperation
import one.volod.rickandmodry.core.models.domain.CharacterPage
import one.volod.rickandmorty.core.repository.CharacterRepository
import javax.inject.Inject

class FetchCharacterPageUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
) {

    suspend operator fun invoke(page: Int): ApiOperation<CharacterPage> =
        characterRepository.fetchCharacterPage(page = page)
}
