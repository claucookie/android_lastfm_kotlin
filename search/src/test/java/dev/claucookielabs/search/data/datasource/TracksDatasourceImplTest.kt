package dev.claucookielabs.search.data.datasource

import com.nhaarman.mockitokotlin2.*
import dev.claucookielabs.search.BuildConfig
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.model.api.ApiSearchBaseResponse
import dev.claucookielabs.search.data.model.api.ApiTrackMatches
import dev.claucookielabs.search.data.model.api.ApiTracks
import dev.claucookielabs.search.fixtures.aListOfApiTracks
import dev.claucookielabs.search.fixtures.anotherListOfApiTracks
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
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(aListOfApiTracks())), "3")

        whenever(mockSearchApi.listTracksByName(eq(""), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName("")
            .test()
            .assertValue(aListOfApiTracks())
    }

    @Test
    fun `test getTracksByName() SHOULD return 2 tracks WHEN input is matching 2 track names`() {
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(anotherListOfApiTracks())), "2")
        val input = "ad"

        whenever(mockSearchApi.listTracksByName(eq(input), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName(input)
            .test()
            .assertValue(anotherListOfApiTracks())
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

    @Test
    fun `test getTracksByName() SHOULD retrieve data from SearchApi AND pass correct params`() {
        val input = "adfaowihfowi"
        val apiBaseResponse = ApiSearchBaseResponse(ApiTrackMatches(ApiTracks(listOf())), "0")

        whenever(mockSearchApi.listTracksByName(eq(input), any(), any(), any())).thenReturn(Single.just(apiBaseResponse))

        tracksDatasource
            .getTracksByName(input)
            .test()
            .assertValue(listOf())

        verify(mockSearchApi).listTracksByName(input, BuildConfig.LAST_FM_API_KEY, "json", "track.search")
    }

}