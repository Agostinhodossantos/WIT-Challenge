package com.agostinho.witchallenge.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("group")
    suspend fun getWeatherByCityId(
        @Query("id") cityId: String,
        @Query("appid") clientApiKey: String,
        @Query("units") units: String
    ): WeatherResponse
}