package dev.claucookielabs.search.data.model.api

import com.google.gson.annotations.SerializedName
import dev.claucookielabs.search.domain.model.ImageInfo
import dev.claucookielabs.search.domain.model.TrackInfo

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

fun ApiTrackInfo.toDomain() : TrackInfo {
    return TrackInfo(name, artist, images.map{ item -> item.toDomain() })
}

private fun ApiImageInfo.toDomain(): ImageInfo {
    return ImageInfo(url, sizeType)
}
