//package di
//
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import io.ktor.client.HttpClient
//import io.ktor.client.engine.okhttp.OkHttp
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.plugins.defaultRequest
//import io.ktor.client.plugins.logging.Logger
//import io.ktor.client.plugins.logging.Logging
//import io.ktor.client.plugins.logging.SIMPLE
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.serialization.json.Json
//import KtorClient
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Singleton
//    @Provides
//    fun provideHttpClient(): HttpClient =
//        HttpClient(OkHttp) {
//            defaultRequest { url("https://rickandmortyapi.com/api/") }
//
//            install(Logging) {
//                logger = Logger.SIMPLE
//            }
//
//            install(ContentNegotiation) {
//                json(Json {
//                    ignoreUnknownKeys = true
//                })
//            }
//        }
//
//    @Singleton
//    @Provides
//    fun provideKtorClient(httpClient: HttpClient): KtorClient {
//        return KtorClient(httpClient)
//    }
//}
