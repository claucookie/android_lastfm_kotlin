package dev.claucookielabs.lastfm.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.claucookielabs.lastfm.presentation.ui.MainActivity

@Subcomponent
interface MainActivitySubcomponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>()
}