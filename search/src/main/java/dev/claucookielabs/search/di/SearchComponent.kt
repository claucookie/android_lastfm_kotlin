package dev.claucookielabs.search.di

import dagger.Component
import dev.claucookielabs.core.CoreComponent
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

@Component(
    modules = [SearchModule::class],
    dependencies = [CoreComponent::class]
)
interface SearchComponent {
    fun inject(searchTrackFragment: SearchTrackFragment)
}