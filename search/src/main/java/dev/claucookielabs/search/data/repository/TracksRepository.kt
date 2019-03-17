package dev.claucookielabs.search.data.repository

import dev.claucookielabs.search.data.datasource.TracksDatasource
import dev.claucookielabs.search.data.model.api.ApiTrackInfo
import io.reactivex.Single
import javax.inject.Inject

interface TracksRepository {
    fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>>
}

class TracksRepositoryImpl @Inject constructor(): TracksRepository {

    @Inject
    lateinit var tracksDatasource: TracksDatasource

    override fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>> {
        return tracksDatasource.getTracksByName(trackName)
    }

}