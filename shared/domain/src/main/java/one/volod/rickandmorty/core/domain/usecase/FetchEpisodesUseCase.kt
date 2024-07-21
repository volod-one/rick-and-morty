package one.volod.rickandmorty.core.domain.usecase

import one.volod.core.network.ApiOperation
import one.volod.rickandmodry.core.models.domain.Episode
import one.volod.rickandmorty.core.repository.EpisodesRepository
import javax.inject.Inject

class FetchEpisodesUseCase @Inject constructor(
    private val episodesRepository: EpisodesRepository,
) {

    suspend operator fun invoke(episodesId: List<Int>): ApiOperation<List<Episode>> =
        episodesRepository.fetchEpisodes(episodesId)
}
