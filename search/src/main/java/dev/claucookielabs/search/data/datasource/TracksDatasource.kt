package dev.claucookielabs.search.data.datasource

import dev.claucookielabs.search.data.model.api.ApiTrackInfo

interface TracksDatasource {
    fun getTracksByName(trackName: String): List<ApiTrackInfo>
}

class TracksDatasourceImpl : TracksDatasource {
    override fun getTracksByName(trackName: String): List<ApiTrackInfo> {
        return listOf()
    }

}