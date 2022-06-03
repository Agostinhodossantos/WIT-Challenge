package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind (
    @Expose @SerializedName("speed") val speed: Double,
    @Expose @SerializedName("deg") val deg: Int
)