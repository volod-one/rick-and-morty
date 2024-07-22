//import KtorClient
//import endpoints.getCharacter
//import endpoints.getCharacterByPage
//import domain.Character
//import domain.CharacterPage
//import javax.inject.Inject
//
//class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {
//
//    suspend fun fetchCharacterPage(page: Int): ApiOperation<CharacterPage> =
//        ktorClient.getCharacterByPage(pageNumber = page)
//
//    suspend fun fetchCharacter(characterId: Int): ApiOperation<Character> =
//        ktorClient.getCharacter(id = characterId)
//}
