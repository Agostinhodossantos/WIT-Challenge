package com.agostinho.witchallenge.models

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country") val country: String,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int
)