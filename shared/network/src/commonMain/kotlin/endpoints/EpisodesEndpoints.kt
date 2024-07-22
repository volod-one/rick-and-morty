//package endpoints
//
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import ApiOperation
//import KtorClient
//import one.volod.rickandmodry.core.models.domain.Episode
//import one.volod.rickandmodry.core.models.remote.RemoteEpisode
//import one.volod.rickandmodry.core.models.remote.toDomainEpisode
//
///**
// * @param episodeId: List<Int>
// * @return ApiOperation<Episode>
// */
//suspend fun KtorClient.getEpisode(episodeId: Int): ApiOperation<Episode> {
//    return safeApiCall {
//        client.get("episode/$episodeId")
//            .body<RemoteEpisode>()
//            .toDomainEpisode()
//    }
//}
//
///**
// * @param episodeIds: List<Int>
// * @return ApiOperation<List<Episode>>
// */
//suspend fun KtorClient.getEpisodes(episodeIds: List<Int>): ApiOperation<List<Episode>> {
//    return if (episodeIds.size == 1) {
//        getEpisode(episodeIds.first()).mapSuccess { episode ->
//            listOf(episode)
//        }
//    } else {
//        val idsCommaSeparated = episodeIds.joinToString(separator = ",")
//        safeApiCall {
//            client.get("episode/$idsCommaSeparated")
//                .body<List<RemoteEpisode>>()
//                .map { it.toDomainEpisode() }
//        }
//    }
//}
