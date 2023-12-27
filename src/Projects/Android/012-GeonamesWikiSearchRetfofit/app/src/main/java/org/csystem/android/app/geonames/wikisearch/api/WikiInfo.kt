package org.csystem.android.app.geonames.wikisearch.api

import kotlinx.serialization.Serializable

@Serializable
class WikiInfo {
    var summary: String? = null
    var elevation = 0
    var lng = 0.0
    var rank = 0
    var thumbnailImg: String? = null
    var lang: String? = null
    var title: String? = null
    var lat = 0.0
    var wikipediaUrl: String? = null
    var geoNameId = 0
    var countryCode: String? = null
    var feature: String? = null

    override fun toString() = "Summary:${summary?.substring(0, 10)}, $lng, $lat"
}