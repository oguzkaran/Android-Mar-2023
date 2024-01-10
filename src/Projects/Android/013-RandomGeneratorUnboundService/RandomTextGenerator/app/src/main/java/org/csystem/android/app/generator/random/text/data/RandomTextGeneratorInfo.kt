package org.csystem.android.app.generator.random.text.data

import java.io.Serializable

data class RandomTextGeneratorInfo(val fileName: String, val count: Int, val min: Int, val bound: Int) : Serializable