/*----------------------------------------------------------------------------------------------------------------------
    Thread'lerin sonlandırılması:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readChar
import java.util.*
import kotlin.system.exitProcess

private fun createTimerTask() : TimerTask
{
    var seconds = 0L

    return object: TimerTask() {
        override fun run()
        {
            printDuration(seconds++)
        }
    }
}

private fun printDuration(seconds: Long)
{
    val hour = seconds / 60 / 60
    val minute = seconds / 60 % 60
    val second = seconds % 60

    print("%02d:%02d:%02d\r".format(hour, minute, second))
}

private fun readCharProc()
{
    while (true) {
        val ch = readChar()

        clearScreen()

        if (ch == 'b')
            break

        if (ch == 'd')
            exitProcess(0);
    }
}

fun clearScreen()
{
    for (i in 1..26)
        println()
}

private fun runApp()
{
    var flag = false

    while (true) {
        readCharProc()

        if (flag)
            continue

        val timer = Timer()

        println("Press d to stop chronometer!...")
        timer.scheduleAtFixedRate(createTimerTask(), 0, 1000)
        flag = true
    }
}

fun main() = runApp()


