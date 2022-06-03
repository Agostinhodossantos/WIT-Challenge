package com.agostinho.witchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Clouds (
    @Expose @SerializedName("all") val all: String
)