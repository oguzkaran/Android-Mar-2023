package org.csystem.util.iterable.kotlin

fun <T> write(iterable: Iterable<T>, separator: Char = ' ', end: Char = '\n')
{
    for (t in iterable)
        print("$t$separator")

    print(end)
}