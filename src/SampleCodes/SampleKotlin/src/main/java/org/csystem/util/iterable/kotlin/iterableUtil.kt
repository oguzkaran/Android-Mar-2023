package org.csystem.util.iterable.kotlin

fun <T> write(iterable: Iterable<T>, separator: Char = ' ', end: Char = '\n')
{
    iterable.forEach {print("$it$separator")}
    print(end)
}