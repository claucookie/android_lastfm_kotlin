package dev.claucookielabs.search.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

@Subcomponent(
    modules = [SearchModule::class]
)
interface SearchSubComponent: AndroidInjector<SearchTrackFragment> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<SearchTrackFragment>()
}