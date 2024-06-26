package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("login")
    val login: Login? = null,
    @SerializedName("dob")
    val dob: Dob? = null,
    @SerializedName("registered")
    val registered: Registered? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("cell")
    val cell: String? = null,
    @SerializedName("id")
    val id: Id? = null,
    @SerializedName("picture")
    val picture: Picture? = null,
    @SerializedName("nat")
    val nat: String? = null,
)