package dev.claucookielabs.search.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import dagger.android.support.DaggerFragment
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import dev.claucookielabs.search.presentation.presenter.SearchTrackPresenterImpl
import javax.inject.Inject

class SearchTrackFragment : DaggerFragment(), SearchTrackView {

    @Inject
    lateinit var presenter: SearchTrackPresenterImpl

    private lateinit var tracksRv: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_search, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initTracksRv()
        presenter.loadTracksByName("hello")
    }

    override fun onStop() {
        presenter.stop()
        super.onStop()
    }

    override fun hideTracks() {
        // Show loading
    }

    override fun showTracks(tracksList: List<TrackInfo>) {
        tracksRv.adapter = TracksAdapter(tracksList)
    }

    override fun showError() {
        // Show error
    }

    private fun initViews(view: View) {
        tracksRv = view.findViewById(R.id.tracks_rv)
    }

    private fun initTracksRv() {
        tracksRv.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        }
    }

}