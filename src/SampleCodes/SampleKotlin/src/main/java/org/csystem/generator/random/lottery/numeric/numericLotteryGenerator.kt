package org.csystem.generator.random.lottery.numeric

import kotlin.random.Random

fun numericLotteryNumbers(count: Int, random: Random = Random) : Array<IntArray>
{
    return generateSequence { numericLotteryNumbers(random) }.take(count).toList().toTypedArray()
}

fun numericLotteryNumbers(random: Random = Random): IntArray
{
    return generateSequence { random.nextInt(1, 50) }.distinct().take(6).sorted().toList().toIntArray()
}

