package com.pavanvulisetti.myapplication.di.component

import android.content.Context
import com.pavanvulisetti.myapplication.di.ApplicationContext
import com.pavanvulisetti.myapplication.CardApplication
import com.pavanvulisetti.myapplication.data.api.NetworkService
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import com.pavanvulisetti.myapplication.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun inject(application: CardApplication)

    fun getNetworkService(): NetworkService

    fun getUserCardsRepository(): UserCardsRepository

}