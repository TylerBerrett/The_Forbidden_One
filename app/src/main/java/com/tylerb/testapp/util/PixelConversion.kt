package com.tylerb.testapp.util

import android.content.res.Resources.getSystem

val Int.pxToDp: Int get() = (this / getSystem().displayMetrics.density).toInt()
val Int.dpToPx: Int get() = (this * getSystem().displayMetrics.density).toInt()