package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.RegisterActivity
import java.lang.ref.WeakReference

class RegisterActivityListenerViewModel(activity: RegisterActivity) {
    private val mWeakReference = WeakReference(activity)

    fun handleRegisterButton() = mWeakReference.get()?.registerButtonClicked()
    fun handleCloseButton() = mWeakReference.get()?.closeButtonClicked()
}