package dev.claucookielabs.search.data.model

import com.google.gson.annotations.SerializedName

class ApiTrackMatches(
    @SerializedName("trackmatches") val trackMatches: ApiTracks
)

class ApiTracks(
    @SerializedName("track") val tracks: List<ApiTrackInfo>
)

class ApiTrackInfo(
    @SerializedName("name") val name: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("image") val images: List<ApiImageInfo>
)

class ApiImageInfo(
    @SerializedName("#text") val url: String,
    @SerializedName("size") val sizeType: String
)