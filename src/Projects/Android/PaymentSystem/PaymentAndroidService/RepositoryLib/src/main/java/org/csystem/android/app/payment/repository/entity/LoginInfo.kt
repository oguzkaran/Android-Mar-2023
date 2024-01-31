package org.csystem.android.app.payment.repository.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDateTime

@Entity(tableName = "login_info", indices = [Index("username")],
    foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = ["username"], childColumns = ["username"],
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)])
data class LoginInfo(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                     var username: String = "",
                     var password: String = "",
                     var success: Boolean = true,
                     @ColumnInfo(name = "login_date_time") var loginDateTime: LocalDateTime = LocalDateTime.now()) : Serializable