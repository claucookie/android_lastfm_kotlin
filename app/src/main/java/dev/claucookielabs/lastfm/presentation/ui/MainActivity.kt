package dev.claucookielabs.lastfm.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.claucookielabs.lastfm.R
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.content_layout,
            SearchTrackFragment()
        ).commitNow()
    }
}
