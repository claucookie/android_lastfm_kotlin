package dev.claucookielabs.search.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

@Module
abstract class SearchBindingModule {

    @ContributesAndroidInjector(modules = [SearchViewModule::class, SearchModule::class])
    abstract fun searchFragment(): SearchTrackFragment

}