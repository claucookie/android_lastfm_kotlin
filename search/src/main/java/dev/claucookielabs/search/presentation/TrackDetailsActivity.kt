package dev.claucookielabs.search.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import dev.claucookielabs.core.utils.bindView
import dev.claucookielabs.core.utils.loadImage
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo

private const val EXTRA_TRACK_INFO = "extra_track_info"

fun launchTrackDetailsActivity(from: Activity, trackInfo: TrackInfo) {
    val intent = Intent(from, TrackDetailsActivity::class.java)
    intent.putExtra(EXTRA_TRACK_INFO, trackInfo)
    from.startActivity(intent)
}

class TrackDetailsActivity : DaggerAppCompatActivity() {

    private val trackNameTv by bindView<TextView>(R.id.trackname_tv)
    private val artistNameTv by bindView<TextView>(R.id.artist_tv)
    private val artworkIv by bindView<ImageView>(R.id.artwork_iv)

    private lateinit var trackInfo: TrackInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_details)

        trackInfo = intent.getSerializableExtra(EXTRA_TRACK_INFO) as TrackInfo
        populateData(trackInfo)
    }

    private fun populateData(trackInfo: TrackInfo) {
        artistNameTv.text = trackInfo.artist
        trackNameTv.text = trackInfo.name
        artworkIv.loadImage(trackInfo.images.firstOrNull()?.url ?: "")
    }

}