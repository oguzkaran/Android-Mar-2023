package org.csystem.util.console.kotlin

fun readInt(prompt: String = "", errMessage: String = "") : Int
{
    //...
    print(prompt)
    return readln().toInt()
}

fun readLong(prompt: String = "", errMessage: String = "") : Long
{
    //...
    print(prompt)
    return readln().toLong()
}

fun readDouble(prompt: String = "", errMessage: String = "") : Double
{
    //...
    print(prompt)
    return readln().toDouble()
}

fun readString(prompt: String = "") : String
{
    //...
    print(prompt)
    return readln()
}
