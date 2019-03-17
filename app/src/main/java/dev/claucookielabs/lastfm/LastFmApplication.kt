package dev.claucookielabs.lastfm

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector
import dev.claucookielabs.core.CoreComponent
import dev.claucookielabs.core.CoreComponentProvider
import dev.claucookielabs.core.DaggerCoreComponent
import dev.claucookielabs.lastfm.di.DaggerAppComponent


class LastFmApplication : DaggerApplication(),
    HasActivityInjector,
    CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .coreComponent(provideCoreComponent())
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
}

