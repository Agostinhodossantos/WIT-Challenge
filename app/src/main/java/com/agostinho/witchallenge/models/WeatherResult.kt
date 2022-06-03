package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherResult(
    @Expose @SerializedName("weather") val weather: List<Weather>,
    @Expose @SerializedName("main") val main: Main,
    @Expose @SerializedName("wind") val wind: Wind,
    @Expose @SerializedName("clouds") val clouds: Clouds,
    @Expose @SerializedName("coord") val coord: Coord,
    @Expose @SerializedName("sys") val sys: Sys,
    @Expose @SerializedName("dt") val dt: Int,
    @Expose @SerializedName("timezone") val timezone: Int,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("visibility") val visibility: Int
) : Parcelable