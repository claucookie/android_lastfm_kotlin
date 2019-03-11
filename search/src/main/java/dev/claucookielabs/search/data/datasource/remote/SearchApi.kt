package dev.claucookielabs.search.data.datasource.remote

import dev.claucookielabs.search.data.model.ApiSearchBaseResponse
import dev.claucookielabs.search.data.model.ApiTrackMatches
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