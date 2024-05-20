package com.pavanvulisetti.myapplication.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pavanvulisetti.myapplication.data.repository.UserCardsRepository
import com.pavanvulisetti.myapplication.di.ActivityContext
import com.pavanvulisetti.myapplication.ui.base.ViewModelProviderFactory
import com.pavanvulisetti.myapplication.ui.usercards.UserHorizontalListAdapter
import com.pavanvulisetti.myapplication.ui.usercards.UserListAdapter
import com.pavanvulisetti.myapplication.ui.usercards.UsersListViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsViewModel(userCardsRepository: UserCardsRepository): UsersListViewModel{
        return ViewModelProvider(activity,
            ViewModelProviderFactory(UsersListViewModel::class){
                UsersListViewModel(userCardsRepository)
            }) [UsersListViewModel::class.java]
    }

    @Provides
    fun provideUserListAdapter() = UserListAdapter(ArrayList())

    @Provides
    fun provideUserHorizontalListAdapter() = UserHorizontalListAdapter(ArrayList())
}