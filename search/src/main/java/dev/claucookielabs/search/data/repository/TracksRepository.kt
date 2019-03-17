package dev.claucookielabs.search.data.repository

import dev.claucookielabs.search.data.model.api.ApiTrackInfo

interface TracksRepository {
    fun getTracksByName(trackName: String): List<ApiTrackInfo>
}

class TracksRepositoryImpl : TracksRepository {
    override fun getTracksByName(trackName: String): List<ApiTrackInfo> {
        return listOf()
    }

}