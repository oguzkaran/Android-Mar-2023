package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.MainActivity

data class MainActivityViewModel(val activity: MainActivity)  {
    fun handleRegisterButton() = activity.registerButtonClicked()
    fun handleLoginButton() = activity.loginButtonClicked()
    fun handleCloseButton() = activity.closeButtonClicked()
}