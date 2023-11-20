package org.csystem.android.app.generator.random.string

import kotlin.random.Random

fun generateRandomTextEN(count: Int, random: Random = Random): String
{
    //TODO (Alican): Aşağıdaki algoritmayı StringBuilder, döngü ve forEach kullanmadan yazınız
    val sb = StringBuilder(count)

    (1..count).forEach{_ -> sb.append((if (random.nextBoolean()) 'A' else 'a') + random.nextInt(26))}

    return sb.toString()
}