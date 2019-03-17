package dev.claucookielabs.search.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.TrackInfo
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackPresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import javax.inject.Inject

class SearchTrackFragment : DaggerFragment(), SearchTrackView {

    @Inject
    lateinit var presenter: SearchTrackPresenter

    private lateinit var tracksRv: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_search, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initTracksRv()
    }

    private fun initViews(view: View) {
        tracksRv = view.findViewById(R.id.tracks_rv)
    }

    private fun initTracksRv() {
        tracksRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TracksAdapter(
                listOf(
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf()),
                    TrackInfo("track 1", "artist", listOf())

                )
            )
        }
    }

}