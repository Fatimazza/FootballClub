package io.github.fatimazza.footballclub.utils

import android.view.View
import java.text.SimpleDateFormat
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun formatToSimpleString(date: Date?): String? = with(date ?: Date()){
    SimpleDateFormat("EEE, dd MM yyy").format(this)
}