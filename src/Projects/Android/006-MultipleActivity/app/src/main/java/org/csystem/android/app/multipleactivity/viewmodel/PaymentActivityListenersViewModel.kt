package org.csystem.android.app.multipleactivity.viewmodel

import org.csystem.android.app.multipleactivity.PaymentActivity
import java.lang.ref.WeakReference

class PaymentActivityListenersViewModel(activity: PaymentActivity) {
    private val mWeakReference = WeakReference(activity)
    fun handlePayButton() = mWeakReference.get()?.payButtonClicked()
    fun handleClearButton() = mWeakReference.get()?.clearButtonClicked()
    fun handleCloseButton() = mWeakReference.get()?.closeButtonClicked()
}