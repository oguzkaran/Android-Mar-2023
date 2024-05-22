package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.MakePaymentActivity
import java.lang.ref.WeakReference

class MakePaymentActivityListenerViewModel(activity: MakePaymentActivity) {
    private val m_weakReference = WeakReference(activity);

    fun handlePayButton() = m_weakReference.get()?.payButtonClicked()

    fun handleClearButton() = m_weakReference.get()?.clearButtonClicked()

    fun handleCloseButton() = m_weakReference.get()?.closeButtonClicked()
}