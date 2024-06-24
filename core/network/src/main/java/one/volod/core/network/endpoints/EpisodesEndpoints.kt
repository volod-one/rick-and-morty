package one.volod.core.network.endpoints

import io.ktor.client.call.body
import io.ktor.client.request.get
import one.volod.core.network.ApiOperation
import one.volod.core.network.KtorClient
import one.volod.rickandmorty.core.domain.models.domain.Episode
import one.volod.rickandmorty.core.domain.models.remote.RemoteEpisode
import one.volod.rickandmorty.core.domain.models.remote.toDomainEpisode

/**
 * @param episodeId: List<Int>
 * @return ApiOperation<Episode>
 */
suspend fun KtorClient.getEpisode(episodeId: Int): ApiOperation<Episode> {
    return safeApiCall {
        client.get("episode/$episodeId")
            .body<RemoteEpisode>()
            .toDomainEpisode()
    }
}

/**
 * @param episodeIds: List<Int>
 * @return ApiOperation<List<Episode>>
 */
suspend fun KtorClient.getEpisodes(episodeIds: List<Int>): ApiOperation<List<Episode>> {
    return if (episodeIds.size == 1) {
        getEpisode(episodeIds.first()).mapSuccess { episode ->
            listOf(episode)
        }
    } else {
        val idsCommaSeparated = episodeIds.joinToString(separator = ",")
        safeApiCall {
            client.get("episode/$idsCommaSeparated")
                .body<List<RemoteEpisode>>()
                .map { it.toDomainEpisode() }
        }
    }
}
