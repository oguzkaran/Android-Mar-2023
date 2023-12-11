package org.csystem.android.app.payment.repository.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDateTime

@Entity(tableName = "login_info")
data class LoginInfo(@PrimaryKey var id: Long = 0,
                     var username: String = "",
                     var password: String = "",
                     var success: Boolean = true,
                     @ColumnInfo(name = "login_date_time") var loginDateTime: LocalDateTime = LocalDateTime.now()) : Serializable