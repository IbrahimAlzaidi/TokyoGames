package com.example.tokyogames.util

import android.util.Log

fun <T> T?.log(tag: String = "GREEN_APPLE"): T? {
    Log.i(tag, this.toString())
    return this
}