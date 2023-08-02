package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.LoginActivity

data class LoginActivityViewModel(val activity: LoginActivity, var username: String = "", var password: String = "")  {
    fun handleLoginButton() = activity.loginButtonClicked()
}