package com.pavanvulisetti.myapplication.data.api

import com.pavanvulisetti.myapplication.data.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {
    @GET(".")
    suspend fun getUsersFromRandomUserApi(@Query("results") results: Int): UsersResponse
}