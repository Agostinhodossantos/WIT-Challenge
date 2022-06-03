package com.agostinho.witchallenge.network

import com.agostinho.witchallenge.models.WeatherResult
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @Expose @SerializedName("cnt") val cnt: Int,
    @Expose @SerializedName("list") val list: List<WeatherResult>)