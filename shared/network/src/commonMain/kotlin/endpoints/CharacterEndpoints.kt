//package endpoints
//
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import ApiOperation
//import KtorClient
//import one.volod.rickandmodry.core.models.domain.CharacterPage
//import one.volod.rickandmodry.core.models.remote.RemoteCharacter
//import one.volod.rickandmodry.core.models.remote.RemoteCharacterPage
//import one.volod.rickandmodry.core.models.remote.toDomainCharacter
//import one.volod.rickandmodry.core.models.remote.toDomainCharacterPage
//
///**
// * @param id: Int
// * @return ApiOperation<Character>
// */
//suspend fun KtorClient.getCharacter(id: Int): ApiOperation<Character> {
//    characterCache[id]?.let { return ApiOperation.Success(it) }
//
//    return safeApiCall {
//        client.get("character/$id")
//            .body<RemoteCharacter>()
//            .toDomainCharacter()
//            .also { characterCache[id] = it }
//    }
//}
//
///**
// * @param pageNumber: Int
// * @return ApiOperation<CharacterPage>
// */
//suspend fun KtorClient.getCharacterByPage(pageNumber: Int): ApiOperation<CharacterPage> {
//    return safeApiCall {
//        client.get("character/?page=$pageNumber")
//            .body<RemoteCharacterPage>()
//            .toDomainCharacterPage()
//    }
//}
