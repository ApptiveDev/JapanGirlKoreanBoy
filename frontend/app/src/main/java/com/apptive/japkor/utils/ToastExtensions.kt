package com.apptive.japkor.utils

import android.content.Context
import androidx.annotation.StringRes
import com.apptive.japkor.ui.components.CustomToast

/**
 * Convenience helpers so any module can trigger app-styled toasts quickly.
 */
fun Context.toast(message: String) {
    CustomToast.show(this, message)
}

fun Context.toast(@StringRes messageRes: Int) {
    CustomToast.show(this, messageRes)
}

fun Context.successToast(message: String, long: Boolean = false) {
    CustomToast.showSuccess(this, message, long)
}

fun Context.errorToast(message: String, long: Boolean = false) {
    CustomToast.showError(this, message, long)
}

fun Context.debugToast(message: String, long: Boolean = false) {
    CustomToast.showDebug(this, message, long)
}
