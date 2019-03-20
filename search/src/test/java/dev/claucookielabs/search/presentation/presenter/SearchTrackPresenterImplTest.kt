package dev.claucookielabs.search.presentation.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.claucookielabs.search.domain.SearchTrackByNameUseCase
import dev.claucookielabs.search.fixtures.aListOfTracks
import dev.claucookielabs.search.presentation.SearchTrackContract
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class SearchTrackPresenterImplTest {

    private lateinit var searchTrackPresenter: SearchTrackPresenterImpl
    private val mockView: SearchTrackContract.SearchTrackView = mock()
    private val mockSearchTrackByNameUseCase: SearchTrackByNameUseCase = mock()

    @Before
    fun setUp() {
        searchTrackPresenter = SearchTrackPresenterImpl(mockView, mockSearchTrackByNameUseCase)
    }

    @Test
    fun `test loadTracksByName()  SHOULD retrieve  data from usecase`() {
        val disposable = Single.just(aListOfTracks()).subscribe()
        // Pass an observable instead
        whenever(mockSearchTrackByNameUseCase.execute(any(), any(), any())).thenReturn(disposable)

        searchTrackPresenter.loadTracksByName("")

        verify(mockSearchTrackByNameUseCase.buildBaseUseCase(any()))
    }
}