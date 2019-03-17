package dev.claucookielabs.search.data.datasource

import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.model.api.ApiTrackInfo
import io.reactivex.Single
import javax.inject.Inject

interface TracksDatasource {
    fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>>
}

class TracksDatasourceImpl : TracksDatasource {

    @Inject
    lateinit var searchApi: SearchApi

    override fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>> {
        return searchApi.listTracksByName(trackName, "9556cfb87fe52e0f72bdaa3163dda5cf")
            .map {
                it.results.trackMatches.tracks
            }
    }

}