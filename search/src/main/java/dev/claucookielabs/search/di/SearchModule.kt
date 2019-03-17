package dev.claucookielabs.search.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.claucookielabs.search.data.datasource.TracksDatasource
import dev.claucookielabs.search.data.datasource.TracksDatasourceImpl
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import dev.claucookielabs.search.data.repository.TracksRepository
import dev.claucookielabs.search.data.repository.TracksRepositoryImpl
import dev.claucookielabs.search.domain.SearchTrackByNameSingleUseCase
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackPresenter
import dev.claucookielabs.search.presentation.SearchTrackContract.SearchTrackView
import dev.claucookielabs.search.presentation.presenter.SearchTrackPresenterImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class SearchModule {

    @Provides
    fun provideRestApi(okHttpClient: OkHttpClient): SearchApi {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    fun provideOkHttp(): OkHttpClient = OkHttpClient()

    @Provides
    fun provideTracksRepository(
        datasource: TracksDatasource
    ): TracksRepository = TracksRepositoryImpl(datasource)

    @Provides
    fun provideTracksDatasource(
        searchApi: SearchApi
    ): TracksDatasource = TracksDatasourceImpl(searchApi)

    @Provides
    fun providesSearchPresenter(
        searchTrackView: SearchTrackView,
        searchTrackByNameUseCase: SearchTrackByNameSingleUseCase
    ): SearchTrackPresenter {
        return SearchTrackPresenterImpl(searchTrackView, searchTrackByNameUseCase)
    }

    @Provides
    fun providesSearchTrackByNameUseCase(tracksRepository: TracksRepository) =
        SearchTrackByNameSingleUseCase(tracksRepository)
}