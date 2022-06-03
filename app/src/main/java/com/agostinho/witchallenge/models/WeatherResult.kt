package com.agostinho.witchallenge.models

import com.google.gson.annotations.SerializedName

data class WeatherResult(
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("coord") val coord: Coord,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("dt") val dt: Int,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("visibility") val visibility: Int
)