package com.pavanvulisetti.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("results")
    val results: List<Result> = ArrayList(),
    @SerializedName("info")
    val info: Info? = null,
)
















