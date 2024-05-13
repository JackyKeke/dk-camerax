package com.dakingx.dkcamerax.ext

import android.util.Log
import com.dakingx.dkcamerax.BuildConfig

fun String.logI(): String = apply { LogUtils.i(this) }
fun String.logD(): String = apply { LogUtils.d(this) }
fun String.logE(): String = apply { LogUtils.e(this) }
fun String.logV(): String = apply { LogUtils.v(this) }
fun String.logW(): String = apply { LogUtils.w(this) }

internal object LogUtils {
    private const val TAG = "camera-sdk-log"

    private var logSwitch = BuildConfig.DEBUG

    @JvmStatic
    @JvmOverloads
    fun i(s: String, tag: String = TAG) {
        if (logSwitch) Log.i(tag, s)
    }

    @JvmStatic
    @JvmOverloads
    fun d(s: String, tag: String = TAG) {
        if (logSwitch) Log.d(tag, s)
    }

    @JvmStatic
    @JvmOverloads
    fun e(s: String, tag: String = TAG) {
        if (logSwitch) Log.e(tag, s)
    }

    @JvmStatic
    @JvmOverloads
    fun v(s: String, tag: String = TAG) {
        if (logSwitch) Log.v(tag, s)
    }

    @JvmStatic
    @JvmOverloads
    fun w(s: String, tag: String = TAG) {
        if (logSwitch) Log.w(tag, s)
    }
}