package com.yoesuv.infinitescroll.utils

import android.util.Log
import com.yoesuv.infinitescroll.BuildConfig
import com.yoesuv.infinitescroll.Constants

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) Log.d(Constants.TAG_DEBUG, message)
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) Log.e(Constants.TAG_ERROR, message)
}