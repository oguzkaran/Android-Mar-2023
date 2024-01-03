package org.csystem.android.app.payment.repository.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDate

@Entity(tableName = "users")
data class User(@PrimaryKey var username: String = "",
                var password: String = "",
                @ColumnInfo(name = "first_name") var firstName: String = "",
                @ColumnInfo(name = "middle_name") var middleName: String? = "",
                @ColumnInfo(name = "last_name") var lastName: String = "",
                @ColumnInfo(name = "birth_date") var birthDate: LocalDate = LocalDate.now(),
                @ColumnInfo(name = "register_date") var registerDate: LocalDate = LocalDate.now()) : Serializable {
    constructor(username: String, password: String, firstName: String, lastName: String,
                birthDate: LocalDate, registerDate: LocalDate)
    :this(username, password, firstName, null, lastName, birthDate, registerDate)
}
