package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.PaymentActivity
import java.lang.ref.WeakReference

class PaymentActivityListenerViewModel(activity: PaymentActivity) {
    private val m_weakReference = WeakReference(activity);

    fun handleMakePaymentButton() = m_weakReference.get()?.makePaymentButtonClicked()

    fun handlePaymentsButton() = m_weakReference.get()?.paymentsButtonClicked()

    fun handleCloseButton() = m_weakReference.get()?.closeButtonClicked()
}