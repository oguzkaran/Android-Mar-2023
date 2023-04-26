/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı gün, ay ve yıl bilgisine ilişkin tarihin haftanın hangi gününe
    geldiğini döndüren getDayOfWeek global fonksiyonunu aşağıdaki açıklamalara uygun olarak yazınız.

    Açıklama:
    - Aşağıdaki test kodu ile fonksiyonlarınız için genel bir test yapınız
    - Programda tarih zamana ilişkin sınıflar kullanılmayacaktır.
    - getDayOfWeek fonksiyonu 1.1.1900 tarihinden sonraki tarihler için çalışacaktır.
    - Fonksiyonlar geçersiz bir tarih için -1 değerini döndürecektir
    - Haftanın günü bilgisi, 1.1.1900 ile verilen tarih arasındaki toplam gün sayısı hesaplanıp 7 değerine
    göre modu alınarak bulunabilir. Bu değere göre sıfır pazar, 1 pazartesi, ..., 6 değeri de Cumartesi
    gününe karşılık gelir
    - Programda dizi kullanılmayacaktır
    - Aşağıdaki fonksiyonların kesinlikle yazılması koşuluyla istediğiniz fonksiyonu ekleyebilirsiniz.
    - Yazılmış fonksiyonlar içerisinde değişiklik yapabilirsiniz. Ancak test etmeniz gerektiğini unutmayınız
    - Çözüm şu ana kadar gördüğümüz konular kullanılarak yapılacaktır
    - String referansına geri dönen fonksiyonlarda String sınıfını kullanmanız gerekmez. String literal oluştururak
    yapınız

    (İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main() = runtTest();

fun runtTest()
{
    while (true) {
        print("Gün?")
        val day = readInt()

        if (day <= 0)
            break

        print("Ay?")
        val month = readInt()

        print("Yıl?")
        val year = readInt()

        displayDateTR(day, month, year)
        displayDateEN(day, month, year)
    }

    println("Tekrar yapıyor musunuz?")
}

fun readInt() = readln().toInt()

fun displayDateTR(day: Int, month: Int, year: Int)
{
    val dayOfWeek = getDayOfWeek(day, month, year)

    println(when {
        dayOfWeek >= 0 -> "$day ${getMonthNameTR(month)} $year ${getDayOfWeekTR(dayOfWeek)}"
        else -> "Geçersiz Tarih"
    })
}

fun displayDateEN(day: Int, month: Int, year: Int)
{
    val dayOfWeek = getDayOfWeek(day, month, year)

    println(when {
        dayOfWeek >= 0 -> "$day${getDaySuffix(day)} ${getMonthNameEN(month)} $year ${getDayOfWeekEN(dayOfWeek)}"
        else -> "Invalid Date"
    })
}

fun getDaySuffix(day: Int) :String
{
    return when (day) {
        1, 21, 31 -> "st"
        2, 22 -> "nd"
        3, 23 -> "rd"
        else -> "th"
    }
}

fun getDayOfWeekTR(dayOfWeek: Int) : String
{
    return when (dayOfWeek) {
        0 -> "Pazar"
        1 -> "Pazatesi"
        2 -> "Salı"
        3 -> "Çarşamba"
        4 -> "Perşembe"
        5 -> "Cuma"
        else -> "Cumartesi"
    }
}

fun getMonthNameTR(month: Int) : String
{
    return when (month) {
        1 -> "Ocak"
        2 -> "Şubat"
        3 -> "Mart"
        4 -> "Nisan"
        5 -> "Mayıs"
        6 -> "Haziran"
        7 -> "Temmuz"
        8 -> "Ağustos"
        9 -> "Eylül"
        10 -> "Ekim"
        11 -> "Kasım"
        else -> "Aralık"
    }
}

fun getDayOfWeekEN(dayOfWeek: Int) : String
{
    return when (dayOfWeek) {
        0 -> "Sun"
        1 -> "Mon"
        2 -> "Tue"
        3 -> "Wed"
        4 -> "Thu"
        5 -> "Fri"
        else -> "Sat"
    }
}

fun getMonthNameEN(month: Int) : String
{
    return when (month) {
        1 -> "Jan"
        2 -> "Feb"
        3 -> "Mar"
        4 -> "Apr"
        5 -> "May"
        6 -> "Jun"
        7 -> "Jul"
        8 -> "Aug"
        9 -> "Sep"
        10 -> "Oct"
        111 -> "Nov"
        else -> "Dec"
    }
}

fun getDayOfWeek(day: Int, month: Int, year: Int) : Int
{
    if (year < 1900)
        return -1

    val totalDays = getDayOfYear(day, month, year)

    if (totalDays == -1)
        return -1

    return (totalDays + getTotalDays(year)) % 7
}

fun getTotalDays(year: Int) : Int
{
    var totalDays = 0

    for (y in 1900 until year)
        totalDays += if (isLeapYear(y)) 366 else 365

    return totalDays
}

fun getDayOfYear(day: Int, month: Int, year: Int) : Int
{
    if (!isValidDate(day, month, year))
        return -1

    var dayOfYear = day

    for (m in (month - 1) downTo 1)
        dayOfYear += getDaysOfMonth(m, year)

    return dayOfYear
}

fun getDaysOfMonth(month: Int, year: Int) : Int
{
    return when (month) {
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear(year)) 29 else 28
        else -> 31
    }
}

fun isValidDate(day: Int, month: Int, year: Int) = day in 1..31 && month in 1..12 && day <= getDaysOfMonth(month, year)

fun isLeapYear(year: Int) = year % 4 == 0 && year % 100 != 0 || year % 400 == 0