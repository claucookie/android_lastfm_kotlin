package dev.claucookielabs.search.presentation.presenter

import dev.claucookielabs.core.presentation.BasePresenter
import dev.claucookielabs.search.domain.SearchTrackByNameSingleUseCase
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackPresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchTrackPresenterImpl @Inject constructor(
    private val searchTrackView: SearchTrackView,
    private val searchTrackByNameUseCase: SearchTrackByNameSingleUseCase
) : BasePresenter<SearchTrackView>(searchTrackView), SearchTrackPresenter {

    private val searchInputSubject: PublishSubject<String> by lazy { PublishSubject.create<String>() }

    override fun loadTracksByName(name: String) {
        addDisposable(
            searchTrackByNameUseCase.execute(
                name,
                searchTrackView::showTracks,
                searchTrackView::hideTracks
            )
        )
    }
}

