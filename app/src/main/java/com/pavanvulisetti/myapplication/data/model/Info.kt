package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("seed")
    val seed: String? = null,
    @SerializedName("results")
    val results: Long? = null,
    @SerializedName("page")
    val page: Long? = null,
    @SerializedName("version")
    val version: String? = null
)