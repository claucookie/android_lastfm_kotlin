package dev.claucookielabs.lastfm

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector
import dev.claucookielabs.core.CoreComponent
import dev.claucookielabs.core.CoreComponentProvider
import dev.claucookielabs.core.DaggerCoreComponent
import dev.claucookielabs.lastfm.di.DaggerAppComponent
import dev.claucookielabs.search.di.DaggerSearchComponent
import dev.claucookielabs.search.di.SearchComponent
import dev.claucookielabs.search.di.SearchComponentProvider


class LastFmApplication : DaggerApplication(),
    HasActivityInjector,
    CoreComponentProvider,
    SearchComponentProvider {

    private lateinit var coreComponent: CoreComponent
    private lateinit var searchComponent: SearchComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .coreComponent(provideCoreComponent())
            .searchComponent(provideSearchComponent())
            .build()

    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }

    override fun provideSearchComponent(): SearchComponent {
        if (!this::searchComponent.isInitialized) {
            searchComponent = DaggerSearchComponent
                .builder()
                .build()
        }
        return searchComponent
    }
}

