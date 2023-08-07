package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.LoginActivity

data class LoginActivityListenersViewModel(val activity: LoginActivity)  {
    fun handleLoginButton() = activity.loginButtonClicked()
}