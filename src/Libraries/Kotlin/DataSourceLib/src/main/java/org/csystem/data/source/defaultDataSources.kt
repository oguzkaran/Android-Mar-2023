package org.csystem.data.source

import org.csystem.test.data.loadProductsFromFileAsArray
import org.csystem.test.data.loadProductsFromFileAsIterable
import org.csystem.test.data.loadProductsFromFileAsSet
import org.csystem.test.data.loadProductsFromFileAsTreeSet

fun loadDefaultProductsAsArrays() = loadProductsFromFileAsArray("products.csv")
fun loadDefaultProductsAsIterable() = loadProductsFromFileAsIterable("/products.csv")
fun loadDefaultProductsAsSet() = loadProductsFromFileAsSet("/products.csv")
fun loadDefaultProductsAsTreeSet() = loadProductsFromFileAsTreeSet("/products.csv")