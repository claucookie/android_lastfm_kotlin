package dev.claucookielabs.search.data.datasource

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.model.api.ApiSearchBaseResponse
import dev.claucookielabs.search.data.model.api.ApiTrackMatches
import dev.claucookielabs.search.data.model.api.ApiTracks
import dev.claucookielabs.search.fixtures.aListOfTracks
import dev.claucookielabs.search.fixtures.anotherListOfTracks
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class TracksDatasourceImplTest {

    private lateinit var tracksDatasource: TracksDatasourceImpl
    private val mockSearchApi: SearchApi = mock()

    @Before
    fun setUp() {
        tracksDatasource = TracksDatasourceImpl(mockSearchApi)
    }

    @Test
    fun `test getTracksByName() SHOULD return tracks starting by A WHEN input is blank`() {
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(aListOfTracks())), "3")

        whenever(mockSearchApi.listTracksByName(eq(""), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName("")
            .test()
            .assertValue(aListOfTracks())
    }

    @Test
    fun `test getTracksByName() SHOULD return 2 tracks WHEN input is matching 2 track names`() {
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(anotherListOfTracks())), "2")
        val input = "ad"

        whenever(mockSearchApi.listTracksByName(eq(input), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName(input)
            .test()
            .assertValue(anotherListOfTracks())
    }

    @Test
    fun `test getTracksByName() SHOULD return 0 tracks WHEN input is not matching anything`() {
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(listOf())), "0")
        val input = "adfaowihfowi"

        whenever(mockSearchApi.listTracksByName(eq(input), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName(input)
            .test()
            .assertValue(listOf())
    }

    @Test
    fun `test getTracksByName() SHOULD return emptyList  WHEN error occurs`() {
        val input = "adfaowihfowi"

        whenever(mockSearchApi.listTracksByName(eq(input), any(), any(), any())).thenReturn(Single.error(RuntimeException()))

        tracksDatasource
            .getTracksByName(input)
            .test()
            .assertValue(listOf())
    }

}