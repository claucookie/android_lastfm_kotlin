package dev.claucookielabs.search.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.claucookielabs.search.data.datasource.TracksDatasource
import dev.claucookielabs.search.data.datasource.TracksDatasourceImpl
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.repository.TracksRepository
import dev.claucookielabs.search.data.repository.TracksRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class SearchApiModule {

    @Singleton
    @Provides
    fun provideRestApi(okHttpClient: OkHttpClient): SearchApi {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com/2.0/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(SearchApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient = OkHttpClient()

    @Provides
    fun provideTracksRepository(): TracksRepository = TracksRepositoryImpl()

    @Provides
    fun provideTracksDatasource(): TracksDatasource = TracksDatasourceImpl()

}