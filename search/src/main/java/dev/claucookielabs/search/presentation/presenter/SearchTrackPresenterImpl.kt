package dev.claucookielabs.search.presentation.presenter

import dev.claucookielabs.core.presentation.BasePresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackPresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView

class SearchTrackPresenterImpl(
    searchTrackView: SearchTrackView
) : BasePresenter<SearchTrackView>(searchTrackView), SearchTrackPresenter {


}

