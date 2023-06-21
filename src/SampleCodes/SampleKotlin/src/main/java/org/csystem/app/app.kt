/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte birden fazla formatter ile işlem yapan örnek bir fonksiyon yazılmıştır. Detaylar gözardı edilmiştir.
    Bir kütüphane içerisine daha detaylısı eklenecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readString
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun tryParse(str: String) : LocalDate?
{
    val formatters = arrayOf(DateTimeFormatter.ofPattern("dd-MM-yyyy"), DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    for (formatter in formatters) {
        try {
            return LocalDate.parse(str, formatter)
        }
        catch (ignore: DateTimeParseException) {

        }
    }
    return null
}

fun main()
{
    while (true) {
        val str = readString("Tarih bilgisini giriniz:21/06/2023 veya 21-06-2023 veya 2023-06-21:")

        if (str == "elma")
            break

        val result = tryParse(str)
        println(if (result != null) DateTimeFormatter.ISO_DATE.format(result) else "Geçersiz tarih!...")
    }
}