/*----------------------------------------------------------------------
	FILE        : RandomIntGenerator.kt
	AUTHOR      : Android-Mar-2023 Group
	LAST UPDATE : 14.06.2023

	Iterable RandomIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random

import kotlin.random.Random

class RandomIntGenerator(private val mCount: Int, private val mMin: Int, private val mBound: Int, private val mRandom : Random = Random) : Iterable<Int> {
    init {
        if (mCount <= 0 || mMin >= mBound)
            throw IllegalArgumentException("Invalid arguments")
    }

    override fun iterator() = object : Iterator<Int> {
        private var mIndex = -1

        override fun hasNext() = mIndex + 1 < mCount

        override fun next(): Int {
            if (!hasNext())
                throw NoSuchElementException("No such element!...")

            ++mIndex

            return mRandom.nextInt(mMin, mBound)
        }
    }
}