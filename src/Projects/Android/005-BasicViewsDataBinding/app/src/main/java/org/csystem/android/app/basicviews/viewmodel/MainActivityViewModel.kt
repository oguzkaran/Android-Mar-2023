package org.csystem.android.app.basicviews.viewmodel

import org.csystem.android.app.basicviews.MainActivity

class MainActivityViewModel(private val activity: MainActivity) {
    fun handleShowPasswordButton() = activity.showPasswordButtonClicked()

    fun handleRegisterButton() = activity.registerButtonClicked()

    fun handleClearButton() = activity.clearButtonClicked()

    fun handleCloseButton() = activity.closeButtonClicked()
}