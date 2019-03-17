package dev.claucookielabs.search.domain.model

data class TrackInfo(
    val name: String,
    val artist: String,
    val images: List<ImageInfo>
)

data class ImageInfo(
    val url: String,
    val sizeType: String
)