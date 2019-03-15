package dev.claucookielabs.lastfm

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dev.claucookielabs.core.CoreComponent
import dev.claucookielabs.core.CoreComponentProvider
import dev.claucookielabs.core.DaggerCoreComponent
import dev.claucookielabs.lastfm.di.DaggerAppComponent
import javax.inject.Inject


class LastFmApplication : Application(), HasActivityInjector, CoreComponentProvider {

    @Inject
    lateinit var activitiesInjector: DispatchingAndroidInjector<Activity>

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }

    override fun activityInjector() = activitiesInjector
}

