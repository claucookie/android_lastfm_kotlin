package dev.claucookielabs.search.data.repository

import com.nhaarman.mockitokotlin2.*
import dev.claucookielabs.search.data.datasource.TracksDatasource
import dev.claucookielabs.search.fixtures.aListOfApiTracks
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TracksRepositoryImplTest {

    private lateinit var tracksRepository: TracksRepositoryImpl
    private val mockTracksDatasource: TracksDatasource = mock()

    @Before
    fun setUp() {
        tracksRepository = TracksRepositoryImpl(mockTracksDatasource)
    }

    @Test
    fun `test getTracksByName() SHOULD return data from datasource`() {
        whenever(mockTracksDatasource.getTracksByName(any())).thenReturn(Single.just(listOf()))

        tracksRepository.getTracksByName("").test()

        verify(mockTracksDatasource).getTracksByName("")
    }

    @Test
    fun `test getTracksByName() SHOULD pass track name as argument`() {
        val input = "abcc"
        whenever(mockTracksDatasource.getTracksByName(any())).thenReturn(Single.just(aListOfApiTracks()))

        tracksRepository.getTracksByName(input).test()

        // Giving a try to argument captor
        argumentCaptor<String>().apply {
            verify(mockTracksDatasource).getTracksByName(capture())
            assertEquals(input, allValues.first())
        }
    }
}