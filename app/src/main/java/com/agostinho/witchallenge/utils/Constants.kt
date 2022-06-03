package com.agostinho.witchallenge.utils

import com.agostinho.witchallenge.BuildConfig


const val API_KEY = BuildConfig.API_KEY
const val BASE_API = "https://api.openweathermap.org/data/2.5/"


const val WEATHER_INTENT = "weather"
const val UNITS_METRIC = "metric"

const val MY_CITY = "Maputo"
val EUROPEAN_CITIES_LIST = mapOf(
    "LISBON" to 2267057,
    "MADRID" to 3117735,
    "PARIS" to 2988507,
    "LONDON" to 2643743,
    "DUBLIN" to 5344157,
    "VIENNA" to 2761369,
    "COPENHAGEN" to 2618425,
    "MOSCOW" to 524901,
).values.joinToString(  separator = ",",)

