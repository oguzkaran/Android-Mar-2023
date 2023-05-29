/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app

fun main()
{
    var vec = Vector3(2.4F, 6.7F, 0F)
    println(vec)
    vec *=  3F
    println(vec)
}

data class Vector3(val x: Float, val y: Float, val z: Float) {
    operator fun times(value: Float) = Vector3(x * value, y * value, z * value)
    //...
}
