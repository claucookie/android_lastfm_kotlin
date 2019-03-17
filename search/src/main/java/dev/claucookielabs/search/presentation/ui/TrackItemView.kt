package dev.claucookielabs.search.presentation.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.claucookielabs.core.utils.loadImage
import dev.claucookielabs.search.R
import dev.claucookielabs.search.domain.model.TrackInfo

class TrackItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTv: TextView = itemView.findViewById(R.id.name_tv)
    private val coverIv: ImageView = itemView.findViewById(R.id.cover_iv)

    fun bind(trackInfo: TrackInfo) {
        val url = trackInfo.images[1].url
        itemView.loadImage(url, coverIv)
        nameTv.text = trackInfo.name
    }

}