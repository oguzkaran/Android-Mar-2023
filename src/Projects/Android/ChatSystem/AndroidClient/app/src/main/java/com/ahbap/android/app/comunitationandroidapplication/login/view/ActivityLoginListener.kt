package com.ahbap.android.app.comunitationandroidapplication.login.view

import com.ahbap.android.app.comunitationandroidapplication.LoginActivity
import java.lang.ref.WeakReference

class ActivityLoginListener(activity : LoginActivity) {
    private val mWeakReference = WeakReference(activity)

    fun HandlerGetButton() = mWeakReference.get()!!.GetButton()
}