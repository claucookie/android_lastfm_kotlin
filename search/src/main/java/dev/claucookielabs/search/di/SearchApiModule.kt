package dev.claucookielabs.search.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.claucookielabs.search.data.datasource.remote.SearchApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

}