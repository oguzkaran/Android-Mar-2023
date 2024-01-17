package org.csystem.android.library.service.search.wiki

import android.os.Parcel
import android.os.Parcelable

class WikiSearchInfo constructor(`in`: Parcel) : Parcelable {
    val text: String? = `in`.readString()
    val maxRows: Int = `in`.readInt()

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        out.writeString(text)
        out.writeInt(maxRows)
    }

    companion object CREATOR: Parcelable.Creator<WikiSearchInfo?> {
        override fun createFromParcel(`in`: Parcel): WikiSearchInfo? {
            return WikiSearchInfo(`in`)
        }

        override fun newArray(size: Int): Array<WikiSearchInfo?> {
            return arrayOfNulls(size)
        }
    }
}
