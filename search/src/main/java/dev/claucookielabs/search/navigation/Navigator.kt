package dev.claucookielabs.search.navigation

import android.app.Activity
import dev.claucookielabs.search.domain.model.TrackInfo
import dev.claucookielabs.search.presentation.launchTrackDetailsActivity
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openTrackDetails(from: Activity, trackInfo: TrackInfo) {
        launchTrackDetailsActivity(from, trackInfo)
    }

}