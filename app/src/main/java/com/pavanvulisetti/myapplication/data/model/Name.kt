package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
    @SerializedName("title")
    val title: String? = null
)