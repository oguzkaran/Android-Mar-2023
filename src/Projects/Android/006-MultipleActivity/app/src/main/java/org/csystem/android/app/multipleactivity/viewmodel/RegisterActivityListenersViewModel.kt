package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.RegisterActivity

data class RegisterActivityListenersViewModel(val activity: RegisterActivity)  {
    fun handleLoginButton() = activity.registerButtonClicked()
}