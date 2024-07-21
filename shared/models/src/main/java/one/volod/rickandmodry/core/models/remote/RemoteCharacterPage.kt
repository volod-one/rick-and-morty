package one.volod.rickandmodry.core.models.remote

import kotlinx.serialization.Serializable
import one.volod.rickandmodry.core.models.domain.CharacterPage

@Serializable
data class RemoteCharacterPage(
    val info: Info,
    val results: List<RemoteCharacter>,
) {
    @Serializable
    data class Info(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?,
    )
}

fun RemoteCharacterPage.toDomainCharacterPage() = CharacterPage(
    info = CharacterPage.Info(
        count = info.count,
        pages = info.pages,
        next = info.next,
        prev = info.prev,
    ),
    characters = results.map { it.toDomainCharacter() },
)
