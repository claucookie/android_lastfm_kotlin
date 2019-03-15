package dev.claucookielabs.lastfm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.claucookielabs.lastfm.presentation.ui.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}