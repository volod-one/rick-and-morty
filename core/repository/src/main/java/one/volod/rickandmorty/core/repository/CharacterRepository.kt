package one.volod.rickandmorty.core.repository

import one.volod.core.network.ApiOperation
import one.volod.core.network.KtorClient
import one.volod.core.network.endpoints.getCharacter
import one.volod.core.network.endpoints.getCharacterByPage
import one.volod.rickandmodry.core.models.domain.Character
import one.volod.rickandmodry.core.models.domain.CharacterPage
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {

    suspend fun fetchCharacterPage(page: Int): ApiOperation<CharacterPage> =
        ktorClient.getCharacterByPage(pageNumber = page)

    suspend fun fetchCharacter(characterId: Int): ApiOperation<Character> =
        ktorClient.getCharacter(id = characterId)
}
