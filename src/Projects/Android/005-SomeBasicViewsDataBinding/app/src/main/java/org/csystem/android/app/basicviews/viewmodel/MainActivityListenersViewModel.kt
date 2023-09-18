package org.csystem.android.app.basicviews.viewmodel

import org.csystem.android.app.basicviews.MainActivity
import java.lang.ref.WeakReference

class MainActivityListenersViewModel(activity: MainActivity) {
    private val mWeakReference = WeakReference(activity)
    fun handleOpenToggleButton(checked: Boolean) = mWeakReference.get()?.openToggleButtonCheckedChanged(checked)

    fun handleAllowShowPasswordSwitch(checked: Boolean) = mWeakReference.get()?.allowShowPasswordSwitchCheckedChanged(checked)

    fun handleShowPasswordButton() = mWeakReference.get()?.showPasswordButtonClicked()

    fun handleRegisterButton() = mWeakReference.get()?.registerButtonClicked()

    fun handleClearButton() = mWeakReference.get()?.clearButtonClicked()

    fun handleCloseButton() = mWeakReference.get()?.closeButtonClicked()

    fun handleEducationSpinner(pos: Int) = mWeakReference.get()?.educationSpinnerItemSelected(pos)

    fun handleBirthDateDaySpinner(pos: Int) = mWeakReference.get()?.birthDateDaySpinnerItemSelected(pos)
    fun handleBirthDateMonthSpinner(pos: Int) = mWeakReference.get()?.birthDateMonthSpinnerItemSelected(pos)
    fun handleBirthDateYearSpinner(pos: Int) = mWeakReference.get()?.birthDateYearSpinnerItemSelected(pos)
}