package org.csystem.android.app.payment.viewmodel

import org.csystem.android.app.payment.PaymentsActivity
import java.lang.ref.WeakReference

class PaymentsActivityListenerViewModel(activity: PaymentsActivity) {
    private val m_weakReference = WeakReference(activity);

    fun handleListPaymentsButton() = m_weakReference.get()?.listPaymentsButtonClicked()
}