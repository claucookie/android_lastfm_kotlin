package dev.claucookielabs.core.utils

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

fun <ViewT : View> Activity.bindView(@IdRes idRes: Int): Lazy<ViewT> {
    return lazy {
        findViewById<ViewT>(idRes)
    }
}