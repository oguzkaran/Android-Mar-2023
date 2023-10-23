/*----------------------------------------------------------------------------------------------------------------------
    Bir thread başka bir yarattığında hangi thread'in önce çizelmeye gireceği o anki duruma bağlıdır. Yani hangisinin
    önce çizelgelemeye girmesi belirsizdir. (Hatta ayrı CPU ya da çekirdekte olurlarsa gerçekten aynı anda da
    çizelgelemeye girebilirler). Thread'lerin stack alanları birbirinden ayrıdır. Ancak heap alanı ortaktır. Dolayısıyla
    aynı nesne üzerinde birden fazla thread'in işlem yapması durumunda bir takım problemler söz konusu olabilmektedir.
    Bu problemlere tipik olan senkronizsyon problemleri denir. İleride bir takım senkronizasyon problemleri ve çözümleri
    uygulamalar içerisinde ele alınacaktır. Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

import org.csystem.util.console.kotlin.readInt
import org.csystem.util.console.kotlin.readLong
import org.csystem.util.console.kotlin.readString
import org.csystem.util.string.kotlin.getRandomTextEN
import java.io.*
import java.nio.charset.StandardCharsets
import kotlin.random.Random

fun main()
{
    val basePath = readString("Input base path:")
    val count = readInt("Input files count:")
    val dataCount = readLong("Input count per each:")

    (1..count).forEach {TextGeneratorThread(dataCount, File("$basePath-${it}.txt").absolutePath).apply { start() }}
}

class TextGeneratorThread(private val mCount: Long, private val mPath: String, private val mMin: Int = 5, private val mBound: Int = 11, private val mRandom: Random = Random) : Thread() {

    private fun generateCallback(fos: FileOutputStream)
    {
        BufferedWriter(OutputStreamWriter(fos, StandardCharsets.UTF_8)).use { bw ->
            (0..<mCount).forEach { bw.write("${mRandom.getRandomTextEN(mRandom.nextInt(mMin, mBound))}\r\n") }
        }
    }

    override fun run()
    {
        try {
            FileOutputStream(mPath).use {generateCallback(it)}
        }
        catch (ex: IOException) {
            println("IO Problem:${ex.message}")
        }
    }
}