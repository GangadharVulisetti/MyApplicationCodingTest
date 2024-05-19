package com.pavanvulisetti.myapplication.data.api

import com.pavanvulisetti.myapplication.data.model.CardsResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(".")
    suspend fun getCardResponseFromRandomUsers(): CardsResponse

}