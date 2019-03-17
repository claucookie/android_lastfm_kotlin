package dev.claucookielabs.lastfm.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.claucookielabs.core.CoreComponent
import dev.claucookielabs.lastfm.LastFmApplication
import dev.claucookielabs.search.di.SearchApiModule
import dev.claucookielabs.search.di.SearchBindingModule


@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        SearchBindingModule::class,
        SearchApiModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<LastFmApplication> {
    /* We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * */
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun coreComponent(coreComponent: CoreComponent): AppComponent.Builder
        fun build(): AppComponent
    }
}