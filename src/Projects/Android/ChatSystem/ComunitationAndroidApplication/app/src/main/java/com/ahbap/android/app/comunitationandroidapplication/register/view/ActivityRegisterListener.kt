package com.ahbap.android.app.comunitationandroidapplication.register.view

import com.ahbap.android.app.comunitationandroidapplication.Register
import java.lang.ref.WeakReference

class ActivityRegisterListener (activity : Register)
{
    private val mWeakReference = WeakReference(activity)

    fun HandlerRegisterButton() = mWeakReference.get()!!.RegisterButton()
    fun HandlerCloseButton() = mWeakReference.get()!!.finish()
}