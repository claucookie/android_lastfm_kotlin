package dev.claucookielabs.search.di

import dagger.Binds
import dagger.Module
import dev.claucookielabs.search.presentation.SearchTrackContract
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

@Module
abstract class SearchViewModule {

    @Binds
    abstract fun provideSearchTrackView(fragment: SearchTrackFragment): SearchTrackContract.SearchTrackView
}