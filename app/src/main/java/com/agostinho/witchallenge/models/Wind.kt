package com.agostinho.witchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wind (
    @Expose @SerializedName("speed") val speed: Double,
    @Expose @SerializedName("deg") val deg: Int
) : Parcelable