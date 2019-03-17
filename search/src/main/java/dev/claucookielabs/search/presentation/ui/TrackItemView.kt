package dev.claucookielabs.search.presentation.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.TrackInfo

class TrackItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTv: TextView = itemView.findViewById(R.id.name_tv)

    fun bind(trackInfo: TrackInfo) {
        nameTv.text = trackInfo.name
    }

}