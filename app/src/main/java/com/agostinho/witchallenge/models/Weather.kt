package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("main") val main: String,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("icon") val icon: String
) {
    val getIconUrlLarge get() = "https://openweathermap.org/img/wn/$icon@2x.png"
    val getIconUrlMedium get() = "https://openweathermap.org/img/w/$icon.png"
}