package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.RegisterActivity
import java.lang.ref.WeakReference

class RegisterActivityListenersViewModel(activity: RegisterActivity)  {
    private val mWeakReference = WeakReference(activity)
    fun handleLoginButton() = mWeakReference.get()?.registerButtonClicked()
}