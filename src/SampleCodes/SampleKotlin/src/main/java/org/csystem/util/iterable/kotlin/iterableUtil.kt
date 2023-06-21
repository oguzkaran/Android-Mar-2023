package org.csystem.util.iterable.kotlin

fun <T> write(iterable: Iterable<T>, separator: Char = ' ', end: Char = '\n') = iterable.print(separator, end)

fun <T> Iterable<T>.print(separator: Char = ' ', end: Char = '\n')
{
    this.forEach {print("$it$separator")}
    print(end)
}