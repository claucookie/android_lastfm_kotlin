package dev.claucookielabs.lastfm.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dev.claucookielabs.lastfm.R
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.content_layout,
            SearchTrackFragment()
        ).commitNow()
    }
}
