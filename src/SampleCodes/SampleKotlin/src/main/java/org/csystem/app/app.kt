/*----------------------------------------------------------------------------------------------------------------------
    Runnable Java'da functional interface olduğundan Kotlin'de de lambda fonksiyonlar ile kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import org.csystem.util.console.kotlin.readLong
import org.csystem.util.console.kotlin.readString
import org.csystem.util.string.kotlin.getRandomTextEN
import java.io.*
import java.nio.charset.StandardCharsets
import kotlin.random.Random

private fun generateCallback(fos: FileOutputStream, count: Long, random: Random, min: Int, bound: Int)
{
    BufferedWriter(OutputStreamWriter(fos, StandardCharsets.UTF_8)).use { bw ->
        (0..<count).forEach { _ -> bw.write("${random.getRandomTextEN(random.nextInt(min, bound))}\r\n") }
    }
}


fun main()
{
    val basePath = readString("Input base path:")
    val count = readInt("Input files count:")
    val dataCount = readLong("Input count per each:")

    File(basePath).parentFile.mkdirs()

    (1..count).forEach {Thread{ generateTextsCallback(dataCount, File("$basePath-${it}.txt").absolutePath, 5, 11) }
        .apply { start() }}
}

fun generateTextsCallback(count: Long, path: String, min: Int, bound: Int, random: Random = Random)
{
    try {
        FileOutputStream(path).use {generateCallback(it, count, random, min, bound)}
    }
    catch (ex: IOException) {
        println("IO Problem:${ex.message}")
    }
}
