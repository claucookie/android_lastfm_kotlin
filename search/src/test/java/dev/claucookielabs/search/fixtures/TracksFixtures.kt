package dev.claucookielabs.search.fixtures

import dev.claucookielabs.search.data.model.api.*


fun aListOfTracks() = listOf(
    ApiTrackInfo("Adieu", "Adele", aListOfImages()),
    ApiTrackInfo("Adios", "Pepe Quintanilla", aListOfImages()),
    ApiTrackInfo("Advanced love", "Richard", anotherListOfImages())
)

fun anotherListOfTracks() = listOf(
    ApiTrackInfo("Adieu", "Adele", aListOfImages()),
    ApiTrackInfo("Advanced love", "Richard", anotherListOfImages())
)

fun aListOfImages(): List<ApiImageInfo> = listOf(
    ApiImageInfo("https://image1.jpeg", "small"),
    ApiImageInfo("https://image2.jpeg", "medium")
)

fun anotherListOfImages(): List<ApiImageInfo> = listOf(
    ApiImageInfo("https://image3.jpeg", "small")
)
