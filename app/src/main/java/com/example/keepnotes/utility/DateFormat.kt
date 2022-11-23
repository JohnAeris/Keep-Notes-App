package com.example.keepnotes.utility

import java.text.SimpleDateFormat
import java.util.*

fun dateFormat(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("hh:mm a | d MMM, y", Locale.getDefault())
    return format.format(date)
}