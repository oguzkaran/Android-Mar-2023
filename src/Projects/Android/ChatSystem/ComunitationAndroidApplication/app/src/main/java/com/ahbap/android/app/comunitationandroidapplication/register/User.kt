package com.ahbap.android.app.comunitationandroidapplication.register

import java.io.Serializable

data class User(var name : String = "", var nickname : String = "",
                var password : String = "", var confirmedPassword : String  = "") : Serializable
{
}