package dev.claucookielabs.search.data.datasource.remote

import dev.claucookielabs.search.data.model.api.ApiSearchBaseResponse
import dev.claucookielabs.search.data.model.api.ApiTrackMatches
import io.reactivex.Single
import retrofit2.http.Query

interface SearchApi {

    fun listTracksByName(
        @Query("track") trackName: String,
        @Query("api_key") apikey: String,
        @Query("format") responseFormat: String = "json",
        @Query("method") method: String = "track.search"
    ): Single<ApiSearchBaseResponse<ApiTrackMatches>>
}