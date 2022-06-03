package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("main") val main: String,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("icon") val icon: String
) : Parcelable {
    val getIconUrlLarge get() = "https://openweathermap.org/img/wn/$icon@2x.png"
    val getIconUrlMedium get() = "https://openweathermap.org/img/w/$icon.png"
}