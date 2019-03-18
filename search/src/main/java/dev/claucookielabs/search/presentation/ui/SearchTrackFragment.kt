package dev.claucookielabs.search.presentation.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import dagger.android.support.DaggerFragment
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import dev.claucookielabs.search.presentation.presenter.SearchTrackPresenterImpl
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SearchTrackFragment : DaggerFragment(), SearchTrackView {

    @Inject
    lateinit var presenter: SearchTrackPresenterImpl

    private lateinit var tracksRv: RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var tracksAdapter: TracksAdapter
    private val searchInputSubject: PublishSubject<String> by lazy { PublishSubject.create<String>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_search, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initTracksRv()
        presenter.loadTracksByName("a")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        toolbar.inflateMenu(R.menu.action_search)
        val searchView = toolbar.menu.findItem(R.id.action_search)?.actionView as? SearchView
        setupSearchInputListener(searchView)
    }

    private fun setupSearchInputListener(searchView: SearchView?) {
        searchInputSubject
            .throttleLast(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribe { presenter.loadTracksByName(it) }

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchInputSubject.onComplete()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchInputSubject.onNext(newText ?: "")
                return true
            }
        })
    }

    override fun onStop() {
        presenter.stop()
        super.onStop()
    }

    override fun hideTracks() {
        // Show loading
    }

    override fun showTracks(tracksList: List<TrackInfo>) {
        tracksAdapter.setTracks(tracksList)
    }

    override fun showError() {
        // Show error
    }

    private fun initViews(view: View) {
        toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        tracksRv = view.findViewById(R.id.tracks_rv)
    }

    private fun initTracksRv() {
        tracksAdapter = TracksAdapter(listOf())
        tracksRv.apply {
            setHasFixedSize(true)
            adapter = tracksAdapter
            layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        }
    }

}