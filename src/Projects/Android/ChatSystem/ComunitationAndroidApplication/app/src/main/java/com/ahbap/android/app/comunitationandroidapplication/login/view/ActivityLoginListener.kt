package com.ahbap.android.app.comunitationandroidapplication.login.view

import com.ahbap.android.app.comunitationandroidapplication.Login
import java.lang.ref.WeakReference

class ActivityLoginListener(activity : Login)
{
    private val mWeakReference = WeakReference(activity)

    fun HandlerGetButton() = mWeakReference.get()!!.GetButton()
}