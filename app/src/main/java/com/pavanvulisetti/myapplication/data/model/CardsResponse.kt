package com.pavanvulisetti.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class CardsResponse(
    @SerializedName("results")
    val results: List<Result> = ArrayList(),
    @SerializedName("info")
    val info: Info,
)

data class Result(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("location")
    val location: Location,
    @SerializedName("email")
    val email: String,
    @SerializedName("login")
    val login: Login,
    @SerializedName("dob")
    val dob: Dob,
    @SerializedName("registered")
    val registered: Registered,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("id")
    val id: Id,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("nat")
    val nat: String,
)

data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
)

data class Location(
    @SerializedName("street")
    var street: Street? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("postcode")
    var postcode: Int? = null,
    @SerializedName("coordinates")
    var coordinates: Coordinates? = null,
    @SerializedName("timezone")
    var timezone: Timezone? = null
)

data class Street(
    @SerializedName("number")
    val number: Long? = null,
    @SerializedName("name")
    val name: String? = null,
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
)

data class Timezone(
    @SerializedName("offset")
    val offset: String? = null,
    @SerializedName("description")
    val description: String? = null,
)

data class Login(
    @SerializedName("uuid")
    val uuid: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("salt")
    val salt: String? = null,
    @SerializedName("md5")
    val md5: String? = null,
    @SerializedName("sha1")
    val sha1: String? = null,
    @SerializedName("sha256")
    val sha256: String? = null,
)

data class Dob(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("age")
    val age: Long? = null,
)

data class Registered(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("age")
    val age: Long? = null,
)

data class Id(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null,
)

data class Picture(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
)

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