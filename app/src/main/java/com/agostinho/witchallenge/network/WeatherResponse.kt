package com.agostinho.witchallenge.network

import com.agostinho.witchallenge.models.WeatherResult
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list") val list: List<WeatherResult>
)