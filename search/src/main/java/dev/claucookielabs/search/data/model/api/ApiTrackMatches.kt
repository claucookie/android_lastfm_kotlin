package dev.claucookielabs.search.data.model.api

import com.google.gson.annotations.SerializedName

data class ApiTrackMatches(
    @SerializedName("trackmatches") val trackMatches: ApiTracks
)

data class ApiTracks(
    @SerializedName("track") val tracks: List<ApiTrackInfo>
)

data class ApiTrackInfo(
    @SerializedName("name") val name: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("image") val images: List<ApiImageInfo>
)

data class ApiImageInfo(
    @SerializedName("#text") val url: String,
    @SerializedName("size") val sizeType: String
)