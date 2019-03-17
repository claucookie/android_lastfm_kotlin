package dev.claucookielabs.search.domain

import dev.claucookielabs.core.domain.BaseSingleUseCase
import dev.claucookielabs.search.data.model.api.ApiTrackInfo
import dev.claucookielabs.search.data.model.api.toDomain
import dev.claucookielabs.search.data.repository.TracksRepository
import dev.claucookielabs.search.domain.model.TrackInfo
import io.reactivex.Single

class SearchTrackByNameSingleUseCase(
    private val tracksRepository: TracksRepository
) : BaseSingleUseCase<List<TrackInfo>, String>() {

    override fun buildBaseUseCase(param: String): Single<List<TrackInfo>> {
        return tracksRepository.getTracksByName(param)
            .map { apiTrackList -> apiTrackList.map(ApiTrackInfo::toDomain)}
    }
}
