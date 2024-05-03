package one.volod.rickandmorty.repositories

import one.volod.core.network.ApiOperation
import one.volod.core.network.KtorClient
import one.volod.core.network.models.domain.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {

    suspend fun fetchCharacter(characterId: Int): ApiOperation<Character> =
        ktorClient.getCharacter(id = characterId)
}
