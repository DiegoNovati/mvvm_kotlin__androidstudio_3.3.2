package com.template.mvvmtemplate.error

import android.content.Context
import android.util.Log
import android.widget.Toast

import com.template.mvvmtemplate.BuildConfig

/**
 * Class that manages the errors raised by the App. On the debug version the errors are displayed to
 * the user, on the production version the error are sent to Crashlytics.
 */
object ErrorManagement {

    private const val TAG = "ErrorManagement"

    @JvmOverloads
    fun logError(ex: Throwable, context: Context? = null, showMessage: Boolean = true) {
        Log.e(TAG, "logError: ", ex)

        try {
            if (showMessage && BuildConfig.displayErrorMessage && context != null) {
                Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
            } else {
                // Add here the code to send the error to Crashlytics
            }
        } catch (e: Exception) {
            Log.e(TAG, "******** logError: ", e)
        }
    }
}
