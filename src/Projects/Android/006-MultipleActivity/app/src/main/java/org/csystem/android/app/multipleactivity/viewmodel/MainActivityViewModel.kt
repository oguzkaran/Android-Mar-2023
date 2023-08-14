package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.MainActivity
import java.lang.ref.WeakReference

class MainActivityViewModel (activity: MainActivity)  {
    private val mWeakReference = WeakReference(activity)

    fun handleRegisterButton() = mWeakReference.get()?.registerButtonClicked()

    fun handleLoginButton() = mWeakReference.get()?.loginButtonClicked()

    fun handleCloseButton() = mWeakReference.get()?.closeButtonClicked()
}