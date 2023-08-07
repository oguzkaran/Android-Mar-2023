package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.PaymentActivity

data class PaymentActivityViewModel(val activity: PaymentActivity,
                                    var name: String = "", var unitPriceStr: String = "", var quantityStr: String = "") {
    fun handlePayButton() = activity.payButtonClicked()
    fun handleClearButton() = activity.clearButtonClicked()
    fun handleCloseButton() = activity.closeButtonClicked()
}