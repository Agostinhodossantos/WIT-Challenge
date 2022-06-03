package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(
    @Expose @SerializedName("temp") val temp: Double,
    @Expose @SerializedName("feels_like") val feelsLike: Double,
    @Expose @SerializedName("temp_min") val tempMin: Double,
    @Expose @SerializedName("temp_max") val tempMax: Double,
    @Expose @SerializedName("pressure") val pressure: Int,
    @Expose @SerializedName("humidity") val humidity: Int
) : Parcelable {
    val getTempMax get() = "${this.tempMax.toInt()} °"
    val getTempMin get() = "${this.tempMin.toInt()} °"
    val getTemp get() = "${this.temp.toInt()}°"
}