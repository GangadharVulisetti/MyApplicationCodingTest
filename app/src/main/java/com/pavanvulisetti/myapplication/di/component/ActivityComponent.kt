package com.pavanvulisetti.myapplication.di.component

import com.pavanvulisetti.myapplication.di.ActivityScope
import com.pavanvulisetti.myapplication.di.module.ActivityModule
import com.pavanvulisetti.myapplication.ui.usercards.UsersListActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: UsersListActivity)

}