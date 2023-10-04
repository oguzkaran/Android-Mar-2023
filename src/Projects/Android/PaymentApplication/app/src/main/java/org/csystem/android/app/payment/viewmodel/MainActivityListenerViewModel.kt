package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.MainActivity
import java.lang.ref.WeakReference

class MainActivityListenerViewModel(activity: MainActivity) {
    private val mWeakReference = WeakReference(activity)

    fun handleRegisterButton() = mWeakReference.get()?.registerButtonClicked()
    fun handleLoginButton() = mWeakReference.get()?.loginButtonClicked()
    fun handleCloseButton() = mWeakReference.get()?.finish()
}