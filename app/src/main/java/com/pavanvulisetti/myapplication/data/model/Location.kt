package com.pavanvulisetti.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    val street: Street? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("timezone")
    val timezone: Timezone? = null
)