package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.PaymentActivity

data class PaymentActivityListenersViewModel(val activity: PaymentActivity) {
    fun handlePayButton() = activity.payButtonClicked()
    fun handleClearButton() = activity.clearButtonClicked()
    fun handleCloseButton() = activity.closeButtonClicked()
}