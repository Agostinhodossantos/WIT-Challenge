package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Clouds(
    @Expose @SerializedName("all") val all: Int
) : Parcelable