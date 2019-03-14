package dev.claucookielabs.core

import dagger.Component
import javax.inject.Singleton

/**
 * Idea about core component taken from
 * https://proandroiddev.com/using-dagger-in-a-multi-module-project-1e6af8f06ffc
 */
@Component(modules = [CoreModule::class])
@Singleton
interface CoreComponent
