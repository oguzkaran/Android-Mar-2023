package org.csystem.android.app.geonames.wikisearch.api

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WikiSearch(@SerializedName("geonames") val wikiInfo: List<WikiInfo> = emptyList())