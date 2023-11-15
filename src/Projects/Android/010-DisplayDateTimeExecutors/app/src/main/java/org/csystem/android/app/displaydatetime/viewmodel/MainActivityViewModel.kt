package org.csystem.android.app.displaydatetime.viewmodel

import org.csystem.android.app.displaydatetime.MainActivity
import java.lang.ref.WeakReference

class MainActivityViewModel(activity: MainActivity) {
    private val mWeakReference = WeakReference(activity)

    fun handleCloseButton() = mWeakReference.get()?.closeButtonClicked()
}