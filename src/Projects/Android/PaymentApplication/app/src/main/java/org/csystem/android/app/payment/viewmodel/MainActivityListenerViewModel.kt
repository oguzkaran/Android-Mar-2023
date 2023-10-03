package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.MainActivity
import java.lang.ref.WeakReference

class MainActivityListenerViewModel(activity: MainActivity) {
    private var mWeakReference = WeakReference(activity)

    fun handleRegisterButton() = mWeakReference.get()?.registerButtonClicked()
}