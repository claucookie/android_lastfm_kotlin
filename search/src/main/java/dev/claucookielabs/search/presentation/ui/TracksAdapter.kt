package dev.claucookielabs.search.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo

class TracksAdapter(
    private var tracks: List<TrackInfo>,
    private var clickAction: ((info: TrackInfo) -> Unit)? = null
) : RecyclerView.Adapter<TrackItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackItemView {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_track_item, parent, false)
            .let { return TrackItemView(it) }
    }

    override fun getItemCount(): Int = tracks.size

    override fun onBindViewHolder(holder: TrackItemView, position: Int) {
        holder.bind(tracks[position])
        holder.itemView.setOnClickListener { clickAction?.invoke(tracks[position]) }
    }

    fun setTracks(newTracks: List<TrackInfo>) {
        tracks = newTracks
        notifyDataSetChanged()
    }
}

