package org.csystem.test.data

import java.nio.file.Files
import java.nio.file.Path

fun loadNumbersFromFileAsSet(path: String) : Set<Int> =
    Files.newBufferedReader(Path.of(path)).useLines {
        it.drop(1).map {it.toInt()}.toSet()
    }

object NumberFactory {
    fun loadFromFile(path: String) = loadNumbersFromFileAsSet(path)
}