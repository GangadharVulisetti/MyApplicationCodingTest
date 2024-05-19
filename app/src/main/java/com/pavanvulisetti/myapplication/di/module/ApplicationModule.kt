package com.pavanvulisetti.myapplication.di.module

import android.content.Context
import com.pavanvulisetti.myapplication.di.ApplicationContext
import com.pavanvulisetti.myapplication.di.BaseUrl
import com.pavanvulisetti.myapplication.CardApplication
import com.pavanvulisetti.myapplication.data.api.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: CardApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context  {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String {
        return "https://randomuser.me//api/"
    }

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}