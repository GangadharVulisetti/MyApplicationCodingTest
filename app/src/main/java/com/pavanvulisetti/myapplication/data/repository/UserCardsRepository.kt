package com.pavanvulisetti.myapplication.data.repository

import com.pavanvulisetti.myapplication.data.api.NetworkService
import com.pavanvulisetti.myapplication.data.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserCardsRepository @Inject constructor(private val networkService: NetworkService) {

    fun getUser(): Flow<List<Result>> {
        return flow {
            emit(networkService.getCardResponseFromRandomUsers())
        }.map {
            it.results
        }
    }
}