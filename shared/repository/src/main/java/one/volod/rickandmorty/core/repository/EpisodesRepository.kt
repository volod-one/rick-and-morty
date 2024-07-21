package one.volod.rickandmorty.core.repository

import one.volod.core.network.ApiOperation
import one.volod.core.network.KtorClient
import one.volod.core.network.endpoints.getEpisodes
import one.volod.rickandmodry.core.models.domain.Episode
import javax.inject.Inject

class EpisodesRepository @Inject constructor(private val ktorClient: KtorClient) {

    suspend fun fetchEpisodes(characterId: List<Int>): ApiOperation<List<Episode>> {
        return ktorClient.getEpisodes(characterId)
    }
}
