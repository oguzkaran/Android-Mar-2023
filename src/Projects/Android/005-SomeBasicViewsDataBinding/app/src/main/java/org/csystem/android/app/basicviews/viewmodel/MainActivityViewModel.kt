package org.csystem.android.app.basicviews.viewmodel

import org.csystem.android.app.basicviews.MainActivity

class MainActivityViewModel(private val activity: MainActivity) {
    fun handleOpenToggleButton(checked: Boolean) = activity.openToggleButtonCheckedChanged(checked)

    fun handleAllowShowPasswordSwitch(checked: Boolean) = activity.allowShowPasswordSwitchCheckedChanged(checked)

    fun handleShowPasswordButton() = activity.showPasswordButtonClicked()

    fun handleRegisterButton() = activity.registerButtonClicked()

    fun handleClearButton() = activity.clearButtonClicked()

    fun handleCloseButton() = activity.closeButtonClicked()
}