package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(
    @Expose @SerializedName("temp") val temp: Double,
    @Expose @SerializedName("feels_like") val feelsLike: Double,
    @Expose @SerializedName("temp_min") val tempMin: Double,
    @Expose @SerializedName("temp_max") val tempMax: Double,
    @Expose @SerializedName("pressure") val pressure: Int,
    @Expose @SerializedName("humidity") val humidity: Int
) {
    val getTempMax get() = "${this.tempMax.toInt()} °"
    val getTempMin get() = "${this.tempMin.toInt()} °"
    val getTemp get() = "${this.temp.toInt()} °"
}