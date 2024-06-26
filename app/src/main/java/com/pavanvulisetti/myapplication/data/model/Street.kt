package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("number")
    val number: Long? = null,
    @SerializedName("name")
    val name: String? = null,
)
