package com.pavanvulisetti.myapplication

import android.app.Application
import com.pavanvulisetti.myapplication.di.component.ApplicationComponent
import com.pavanvulisetti.myapplication.di.component.DaggerApplicationComponent
import com.pavanvulisetti.myapplication.di.module.ApplicationModule

class CardApplication: Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        // inject dependencies which we want to exist through out the app
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        // when compiler sees this message, it looks in to consumer (for eg this class, provides dependencies what are required
        // we do need this line unless we are consuming some dependency instance in this class
        applicationComponent.inject(this)

    }
}