package dev.claucookielabs.search.presentation

import dev.claucookielabs.search.domain.model.TrackInfo

interface SearchTrackContract {

    interface SearchTrackPresenter {
        fun loadTracksByName(name: String)
    }

    interface SearchTrackView {
        fun hideTracks()
        fun showTracks(tracksList: List<TrackInfo>)
        fun showError()
    }

}