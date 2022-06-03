package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sys(
    @Expose @SerializedName("country") val country: String,
    @Expose @SerializedName("timezone") val timezone: String,
    @Expose @SerializedName("sunrise") val sunrise: Int,
    @Expose @SerializedName("sunset") val sunset: Int
) : Parcelable