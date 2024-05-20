package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("age")
    val age: Long? = null,
)