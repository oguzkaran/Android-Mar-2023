package org.csystem.android.app.payment.viewmodel;

import org.csystem.android.app.payment.OperationsActivity;

import java.lang.ref.WeakReference;

public class OperationsActivityListenerViewModel {
    private final WeakReference<OperationsActivity> m_weakReference;

    public OperationsActivityListenerViewModel(OperationsActivity activity)
    {
        m_weakReference = new WeakReference<>(activity);
    }

    public void handlePaymentButton()
    {
        m_weakReference.get().paymentButtonClicked();
    }

    public void handleLoginInformationButton()
    {
        m_weakReference.get().loginInformationButtonClicked();
    }

    public void handleCloseButton()
    {
        m_weakReference.get().closeButtonClicked();
    }
}
