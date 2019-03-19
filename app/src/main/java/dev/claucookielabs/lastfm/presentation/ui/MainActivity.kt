package dev.claucookielabs.lastfm.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import dev.claucookielabs.lastfm.R
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var searchTrackFragment: SearchTrackFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchTrackFragment = SearchTrackFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.content_layout,
            searchTrackFragment
        ).commitNow()
    }
}
