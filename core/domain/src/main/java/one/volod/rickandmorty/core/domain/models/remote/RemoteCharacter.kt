package one.volod.rickandmorty.core.domain.models.remote

import kotlinx.serialization.Serializable
import one.volod.rickandmorty.core.domain.models.domain.Character
import one.volod.rickandmorty.core.domain.models.domain.CharacterGender
import one.volod.rickandmorty.core.domain.models.domain.CharacterStatus

@Serializable
data class RemoteCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
) {
    @Serializable
    data class Location(
        val name: String,
        val url: String,
    )

    @Serializable
    data class Origin(
        val name: String,
        val url: String,
    )
}

fun RemoteCharacter.toDomainCharacter(): Character {
    val characterGender = when (gender.lowercase()) {
        "female" -> CharacterGender.Female
        "male" -> CharacterGender.Male
        "genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    }
    val characterStatus = when (status.lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }
    return Character(
        created = created,
        episodeIds = episode.map { it.substring(it.lastIndexOf("/") + 1).toInt() },
        gender = characterGender,
        id = id,
        imageUrl = image,
        location = Character.Location(
            name = location.name,
            url = location.url,
        ),
        name = name,
        origin = Character.Origin(
            name = origin.name,
            url = origin.url,
        ),
        species = species,
        status = characterStatus,
        type = type,
    )
}
