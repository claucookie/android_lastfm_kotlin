package dev.claucookielabs.search.fixtures

import dev.claucookielabs.search.data.model.api.ApiImageInfo
import dev.claucookielabs.search.data.model.api.ApiTrackInfo
import dev.claucookielabs.search.domain.model.ImageInfo
import dev.claucookielabs.search.domain.model.TrackInfo


fun aListOfApiTracks() = listOf(
    ApiTrackInfo("Adieu", "Adele", aListOfApiImages()),
    ApiTrackInfo("Adios", "Pepe Quintanilla", aListOfApiImages()),
    ApiTrackInfo("Advanced love", "Richard", anotherListOfApiImages())
)

fun anotherListOfApiTracks() = listOf(
    ApiTrackInfo("Adieu", "Adele", aListOfApiImages()),
    ApiTrackInfo("Advanced love", "Richard", anotherListOfApiImages())
)

fun aListOfApiImages(): List<ApiImageInfo> = listOf(
    ApiImageInfo("https://image1.jpeg", "small"),
    ApiImageInfo("https://image2.jpeg", "medium")
)

fun anotherListOfApiImages(): List<ApiImageInfo> = listOf(
    ApiImageInfo("https://image3.jpeg", "small")
)

fun aListOfTracks() = listOf(
    TrackInfo("Adieu", "Adele", aListOfImages()),
    TrackInfo("Adios", "Pepe Quintanilla", aListOfImages()),
    TrackInfo("Advanced love", "Richard", anotherListOfImages())
)

fun anotherListOfTracks() = listOf(
    TrackInfo("Adieu", "Adele", aListOfImages()),
    TrackInfo("Advanced love", "Richard", anotherListOfImages())
)

fun aListOfImages() = listOf(
    ImageInfo("https://image1.jpeg", "small"),
    ImageInfo("https://image2.jpeg", "medium")
)

fun anotherListOfImages() = listOf(
    ImageInfo("https://image3.jpeg", "small")
)
