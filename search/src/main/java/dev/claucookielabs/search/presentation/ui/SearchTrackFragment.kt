package dev.claucookielabs.search.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.claucookielabs.core.CoreInjectHelper
import dev.claucookielabs.core.DaggerCoreComponent
import dev.claucookielabs.search.R
import dev.claucookielabs.search.di.DaggerSearchComponent

class SearchTrackFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_search, null)

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        DaggerSearchComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(requireActivity().applicationContext))
            .build()
            .inject(this)
    }

}