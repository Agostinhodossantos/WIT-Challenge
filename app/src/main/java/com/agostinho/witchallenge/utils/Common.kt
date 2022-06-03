package com.agostinho.witchallenge.utils

import android.os.Build
import java.time.LocalDateTime
import java.util.*

fun getCurrentTime(): String{
    var c = Calendar.getInstance()
    return "${c.get(Calendar.HOUR)} : ${c.get(Calendar.MINUTE)}"
}