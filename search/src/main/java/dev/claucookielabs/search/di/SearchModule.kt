package dev.claucookielabs.search.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.claucookielabs.search.presentation.ui.SearchTrackFragment

@Module(subcomponents = [SearchSubComponent::class])
abstract class SearchModule {

    @Binds
    @IntoMap
    @ClassKey(SearchTrackFragment::class)
    internal abstract fun bindSearchFragmentInjectorFactory(
        builder: SearchSubComponent.Builder
    ): AndroidInjector.Factory<*>
}