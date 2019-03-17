package dev.claucookielabs.search.presentation.presenter

import dev.claucookielabs.core.presentation.BasePresenter
import dev.claucookielabs.search.domain.SearchTrackByNameSingleUseCase
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackPresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import javax.inject.Inject

class SearchTrackPresenterImpl @Inject constructor(
    private val searchTrackView: SearchTrackView,
    private val searchTrackByNameUseCase: SearchTrackByNameSingleUseCase
) : BasePresenter<SearchTrackView>(searchTrackView), SearchTrackPresenter {

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

