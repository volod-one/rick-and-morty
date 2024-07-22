//import io.ktor.client.HttpClient
//import javax.inject.Inject
//
//class KtorClient @Inject constructor(
//    internal val client: HttpClient,
//) {
//
//    /**
//     * @property characterCache: MutableMap<Int, Character>
//     * Int used as Character ID
//     */
//    internal var characterCache = mutableMapOf<Int, Character>()
//
//    /**
//     * @param apiCall: () -> T
//     * @return ApiOperation<T>
//     */
//    internal inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> =
//        try {
//            ApiOperation.Success(data = apiCall())
//        } catch (e: Exception) {
//            ApiOperation.Failure(e)
//        }
//}
