package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coord(
   @Expose @SerializedName("lon") val long: Double,
   @Expose @SerializedName("lat") val lat: Double
)
