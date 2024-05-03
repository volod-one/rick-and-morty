package one.volod.core.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import one.volod.core.network.models.domain.Character
import one.volod.core.network.models.domain.CharacterPage
import one.volod.core.network.models.domain.Episode
import one.volod.core.network.models.remote.RemoteCharacter
import one.volod.core.network.models.remote.RemoteCharacterPage
import one.volod.core.network.models.remote.RemoteEpisode
import one.volod.core.network.models.remote.toDomainCharacter
import one.volod.core.network.models.remote.toDomainCharacterPage
import one.volod.core.network.models.remote.toDomainEpisode

class KtorClient {

    /**
     * @property client: HttpClient
     */
    private val client = HttpClient(OkHttp) {
        defaultRequest { url("https://rickandmortyapi.com/api/") }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    /**
     * @property characterCache: MutableMap<Int, Character>
     * Int used as Character ID
     */
    private var characterCache = mutableMapOf<Int, Character>()

    /**
     * @param id: Int
     * @return ApiOperation<Character>
     */
    suspend fun getCharacter(id: Int): ApiOperation<Character> {
        characterCache[id]?.let { return ApiOperation.Success(it) }

        return safeApiCall {
            client.get("character/$id")
                .body<RemoteCharacter>()
                .toDomainCharacter()
                .also { characterCache[id] = it }
        }
    }

    /**
     * @param pageNumber: Int
     * @return ApiOperation<CharacterPage>
     */
    suspend fun getCharacterByPage(pageNumber: Int): ApiOperation<CharacterPage> {
        return safeApiCall {
            client.get("character/?page=$pageNumber")
                .body<RemoteCharacterPage>()
                .toDomainCharacterPage()
        }
    }

    /**
     * @param episodeId: List<Int>
     * @return ApiOperation<Episode>
     */
    suspend fun getEpisode(episodeId: Int): ApiOperation<Episode> {
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
    suspend fun getEpisodes(episodeIds: List<Int>): ApiOperation<List<Episode>> {
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

    /**
     * @param apiCall: () -> T
     * @return ApiOperation<T>
     */
    private inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> =
        try {
            ApiOperation.Success(data = apiCall())
        } catch (e: Exception) {
            ApiOperation.Failure(e)
        }
}

sealed interface ApiOperation<T> {

    /**
     * @param data: T
     */
    data class Success<T>(val data: T) : ApiOperation<T>

    /**
     * @param exception: Exception
     */
    data class Failure<T>(val exception: Exception) : ApiOperation<T>

    /**
     * @param transform: (T) -> R
     */
    fun <R> mapSuccess(transform: (T) -> R): ApiOperation<R> {
        return when (this) {
            is Success -> Success(transform(data))
            is Failure -> Failure(exception)
        }
    }

    /**
     * @param block: (T) -> Unit
     */
    fun onSuccess(block: (T) -> Unit): ApiOperation<T> {
        if (this is Success) block(data)
        return this
    }

    /**
     *  @param block: (Exception) -> Unit
     */
    fun onFailure(block: (Exception) -> Unit): ApiOperation<T> {
        if (this is Failure) block(exception)
        return this
    }
}
