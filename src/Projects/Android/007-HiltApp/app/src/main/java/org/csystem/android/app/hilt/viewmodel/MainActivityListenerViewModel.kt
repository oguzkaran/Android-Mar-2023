package org.csystem.android.app.hilt.viewmodel

import org.csystem.android.app.hilt.MainActivity
import java.lang.ref.WeakReference

class MainActivityListenerViewModel(activity: MainActivity) {
    private val mWeakReference = WeakReference(activity)

    fun handleCalculateButton() = mWeakReference.get()?.calculateButtonClicked()

}