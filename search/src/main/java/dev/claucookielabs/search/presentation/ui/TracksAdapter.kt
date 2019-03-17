package dev.claucookielabs.search.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo

class TracksAdapter(private val tracks: List<TrackInfo>) : RecyclerView.Adapter<TrackItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackItemView {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_track_item, parent, false)
            .let {
                return TrackItemView(it)
            }
    }

    override fun getItemCount(): Int = tracks.size

    override fun onBindViewHolder(holder: TrackItemView, position: Int) = holder.bind(tracks[position])
}

