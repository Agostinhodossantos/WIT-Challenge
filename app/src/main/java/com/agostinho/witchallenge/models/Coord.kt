package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coord(
   @Expose @SerializedName("lon") val long: Double,
   @Expose @SerializedName("lat") val lat: Double
): Parcelable
