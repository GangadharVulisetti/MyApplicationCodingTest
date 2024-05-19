package com.pavanvulisetti.myapplication.data.repository

import com.pavanvulisetti.myapplication.data.api.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserCardsRepository @Inject constructor(private val networkService: NetworkService) {
    suspend fun getUser() = networkService.getCardResponseFromRandomUsers()
}