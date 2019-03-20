package dev.claucookielabs.search.domain

import com.nhaarman.mockitokotlin2.*
import dev.claucookielabs.search.data.repository.TracksRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class SearchTrackByNameUseCaseTest {

    private lateinit var searchTrackByNameUseCase: SearchTrackByNameUseCase
    private val mockTracksRepository: TracksRepository = mock()

    @Before
    fun setUp() {
        searchTrackByNameUseCase = SearchTrackByNameUseCase(mockTracksRepository)
    }

    @Test
    fun `test buildBaseUseCase() SHOULD retrieve data from Repository`() {
        val input = "a"
        whenever(mockTracksRepository.getTracksByName(any())).thenReturn(Single.just(listOf()))

        searchTrackByNameUseCase.buildBaseUseCase(input).test()

        verify(mockTracksRepository).getTracksByName(input)
    }
}