package org.csystem.test.data

import java.nio.file.Files
import java.nio.file.Path
import java.util.TreeMap

fun loadNamesFromFile(path: String) : Iterable<String> =
        Files.newBufferedReader(Path.of(path)).useLines {
            it.toList().drop(1)
        }

fun loadNamesFromFileAsMap(path: String) : Map<Int, MutableList<String>>
{
    val map = mutableMapOf<Int, MutableList<String>>()

    Files.newBufferedReader(Path.of(path)).useLines {
        it.map { it.split(",") }
                .forEach {
                    val key = it[0].toInt()

                    if (map.containsKey(key))
                        map[key]?.add(it[1])
                    else
                        map[key] = ArrayList<String>().apply { add(it[1]) }
                }
    }

    return map
}

fun loadNamesFromFileAsTreeMap(path: String) : Map<Int, MutableList<String>>
{
    val map = TreeMap<Int, MutableList<String>>()

    Files.newBufferedReader(Path.of(path)).useLines {
        it.map { it.split(",") }
            .forEach {
                val key = it[0].toInt()

                if (map.containsKey(key))
                    map[key]?.add(it[1])
                else
                    map[key] = ArrayList<String>().apply { add(it[1]) }
            }
    }

    return map
}

object NameFactory {
    fun loadFromFile(path: String) = loadNamesFromFile(path)
    fun loadFromFileAsMap(path: String) = loadNamesFromFileAsMap(path)
}