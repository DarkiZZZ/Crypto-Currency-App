package ru.msokolov.cryptocurrencyapp.formatters

import java.text.SimpleDateFormat
import java.util.*

fun Float.formatThousands(): String{
    val stringBuilder = StringBuilder()
    val formatter = Formatter(stringBuilder, Locale.US)
    formatter.format("%(,.0f", this)
    return stringBuilder.toString()
}

fun Number.dateToString(pattern: String): String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong()
    return SimpleDateFormat(pattern).format(calendar.time)
}