package dev.claucookielabs.search.presentation.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.claucookielabs.search.domain.SearchTrackByNameUseCase
import dev.claucookielabs.search.fixtures.aListOfTracks
import dev.claucookielabs.search.presentation.SearchTrackContract
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import io.reactivex.android.plugins.RxAndroidPlugins
import org.junit.BeforeClass



class SearchTrackPresenterImplTest {

    private lateinit var searchTrackPresenter: SearchTrackPresenterImpl
    private val mockView: SearchTrackContract.SearchTrackView = mock()
    private val mockSearchTrackByNameUseCase: SearchTrackByNameUseCase = mock()


    @Before
    fun setUp() {
        searchTrackPresenter = SearchTrackPresenterImpl(mockView, mockSearchTrackByNameUseCase)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `test loadTracksByName()  SHOULD retrieve  data from usecase`() {
        val listOfTracksSingle = Single.just(aListOfTracks())
        // Pass an observable instead
        whenever(mockSearchTrackByNameUseCase.buildBaseUseCase(any())).thenReturn(listOfTracksSingle)

        searchTrackPresenter.loadTracksByName("")
        verify(mockSearchTrackByNameUseCase).buildBaseUseCase("")
        searchTrackPresenter.loadTracksByName("a")
        verify(mockSearchTrackByNameUseCase).buildBaseUseCase("a")
        searchTrackPresenter.loadTracksByName("b")
        verify(mockSearchTrackByNameUseCase).buildBaseUseCase("b")
    }
}