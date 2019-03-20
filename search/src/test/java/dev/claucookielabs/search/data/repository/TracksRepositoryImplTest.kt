package dev.claucookielabs.search.data.repository

import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.claucookielabs.search.data.datasource.TracksDatasource
import io.reactivex.Single
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
        whenever(mockTracksDatasource.getTracksByName(eq(""))).thenReturn(Single.just(listOf()))

        tracksRepository.getTracksByName("").test()

        verify(mockTracksDatasource).getTracksByName("")
    }

    @Test
    fun `test getTracksByName() SHOULD pass track name as argument`() {
        val input = "abcc"
        whenever(mockTracksDatasource.getTracksByName(eq(input))).thenReturn(Single.just(listOf()))

        tracksRepository.getTracksByName(input).test()

        verify(mockTracksDatasource).getTracksByName(eq(input))
    }
}