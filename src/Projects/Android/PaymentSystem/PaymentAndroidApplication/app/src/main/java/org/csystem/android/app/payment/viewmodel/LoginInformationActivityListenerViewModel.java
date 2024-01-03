package org.csystem.android.app.payment.viewmodel;

import org.csystem.android.app.payment.LoginInformationActivity;

import java.lang.ref.WeakReference;

public class LoginInformationActivityListenerViewModel {
    private final WeakReference<LoginInformationActivity> m_weakReference;

    public LoginInformationActivityListenerViewModel(LoginInformationActivity activity)
    {
        m_weakReference = new WeakReference<>(activity);
    }

    public void handleSuccessLoginsButton()
    {
        m_weakReference.get().successLoginsButtonClicked();
    }

    public void handleFailLoginsButton()
    {
        m_weakReference.get().failLoginsButtonClicked();
    }

    public void handleCloseButton()
    {
        m_weakReference.get().closeButtonClicked();
    }

    public void handleListViewItemSelected(int pos)
    {
        m_weakReference.get().loginInformationItemClicked(pos);
    }


}
