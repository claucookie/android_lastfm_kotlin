package dev.claucookielabs.lastfm.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.claucookielabs.lastfm.LastFmApplication
import javax.inject.Singleton
import dagger.BindsInstance



@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class])
@Singleton
interface AppComponent {
    /* We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     * */
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    /*
     * This is our custom Application class
     * */
    fun inject(application: LastFmApplication)
}