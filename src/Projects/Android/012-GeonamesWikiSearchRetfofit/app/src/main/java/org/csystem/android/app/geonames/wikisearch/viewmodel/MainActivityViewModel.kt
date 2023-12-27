package org.csystem.android.app.geonames.wikisearch.viewmodel

import org.csystem.android.app.geonames.wikisearch.MainActivity
import java.lang.ref.WeakReference

class MainActivityViewModel(activity: MainActivity) {
    private val mWeakReference = WeakReference(activity)

    fun handleGetButtonClicked() = mWeakReference.get()?.getButtonClicked()

}