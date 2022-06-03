package com.agostinho.witchallenge.network

import com.agostinho.witchallenge.models.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherCityResponse(
    @Expose @SerializedName("coord") val coord: Coord,
    @Expose @SerializedName("weather") val weather: List<Weather>,
    @Expose @SerializedName("base") val base: String,
    @Expose @SerializedName("main") val main: Main,
    @Expose @SerializedName("wind") val wind: Wind,
    @Expose @SerializedName("clouds") val clouds: Clouds,
    @Expose @SerializedName("dt") val dt: Int,
    @Expose @SerializedName("sys") val sys: Sys,
    @Expose @SerializedName("timezone") val timezone: Int,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
)
