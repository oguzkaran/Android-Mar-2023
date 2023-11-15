/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun main()
{
    val pool = Executors.newScheduledThreadPool(1)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")

    val future = pool.scheduleAtFixedRate({print("%s\r".format(formatter.format(LocalDateTime.now())))}, 0L, 1, TimeUnit.SECONDS)

    try {
        future.get(3, TimeUnit.SECONDS)
    }
    catch (_: TimeoutException) {
        future.cancel(false)
    }

    pool.shutdown()
}

