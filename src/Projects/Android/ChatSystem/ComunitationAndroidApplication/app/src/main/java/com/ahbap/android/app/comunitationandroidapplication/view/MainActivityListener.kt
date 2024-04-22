package com.ahbap.android.app.comunitationandroidapplication.view

import com.ahbap.android.app.comunitationandroidapplication.MainActivity
import java.lang.ref.WeakReference

class MainActivityListener(activity: MainActivity)
{
    private val mWeakReferences = WeakReference(activity)

    fun HandlerRegisterButton() = mWeakReferences.get()!!.RegisterButton()
    fun HandlerLoginButton() = mWeakReferences.get()!!.LoginButton()

}