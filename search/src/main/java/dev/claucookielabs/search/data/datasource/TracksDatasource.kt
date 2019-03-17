package dev.claucookielabs.search.data.datasource

import dev.claucookielabs.search.BuildConfig
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.model.api.ApiTrackInfo
import io.reactivex.Single
import javax.inject.Inject

interface TracksDatasource {
    fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>>
}

class TracksDatasourceImpl @Inject constructor() : TracksDatasource {

    @Inject
    lateinit var searchApi: SearchApi

    override fun getTracksByName(trackName: String): Single<List<ApiTrackInfo>> {
        return searchApi.listTracksByName(trackName, BuildConfig.LAST_FM_API_KEY)
            .map {
                it.results.trackMatches.tracks
            }
    }

}