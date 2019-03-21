package dev.claucookielabs.search.domain.model

import java.io.Serializable

data class TrackInfo(
    val name: String,
    val artist: String,
    val images: List<ImageInfo>
) : Serializable

data class ImageInfo(
    val url: String,
    val sizeType: String
) : Serializable