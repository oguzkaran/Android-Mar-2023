/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden 'b' girildiğinde saat:dakika:saniye:milisaniye biçiminde bir sayaç başlatan ve 'd' girildiğinde
    sayacı sonlandıran uygulamayı yazınız. Program 'ç' girildiğinde sonlanacaktır. Bu karakterler dışında değer girilmesi
    durumunda hiç bir şey yapılamayacaktır

    Not: Aynı uygulamayı DiplayDateTime uygulamasını bir tane button' basıldığında başltana ve tekrar basıldığında
    sayacı durdurucak şekilde yazınız. Button üzerinde yazı duruma göre değişecektir. İpucu: Toggle button kullanabilirsiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readString
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Timer
import java.util.TimerTask

private fun createTimerTask(formatter: DateTimeFormatter) : TimerTask
{
    return object: TimerTask() {
        override fun run()
        {
            print("%s\r".format(formatter.format(LocalDateTime.now())))
        }
    }
}

fun main()
{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")
    val timer = Timer()

    timer.scheduleAtFixedRate(createTimerTask(formatter), 0, 1000)
    readString("Çıkmak için enter tuşuna basınız\n");
    timer.cancel()
}
