//import KtorClient
//import endpoints.getEpisodes
//import domain.Episode
//import javax.inject.Inject
//
//class EpisodesRepository @Inject constructor(private val ktorClient: KtorClient) {
//
//    suspend fun fetchEpisodes(characterId: List<Int>): ApiOperation<List<Episode>> {
//        return ktorClient.getEpisodes(characterId)
//    }
//}
