/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: LocalDate sınıfını kullanarak iki tarih arasındaki toplam yılı Double türden çıkartma operatörü
    ile hesaplayan kodları yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

operator fun LocalDate.minus(localDate: LocalDate) = ChronoUnit.DAYS.between(localDate, this) / 365.0

fun main()
{
    val birthDate = LocalDate.of(1976, Month.SEPTEMBER, 10)
    val today = LocalDate.now()

    val age = today - birthDate

    println("Age:$age")
}