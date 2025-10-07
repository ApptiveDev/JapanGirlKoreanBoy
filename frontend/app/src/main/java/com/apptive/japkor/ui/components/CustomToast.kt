package com.apptive.japkor.ui.components

import android.content.Context
import android.widget.Toast

object CustomToast {
    fun show(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }

    fun showLong(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
