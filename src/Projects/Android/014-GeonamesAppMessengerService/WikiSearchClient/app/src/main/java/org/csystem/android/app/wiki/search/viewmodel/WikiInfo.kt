package org.csystem.android.app.wiki.search.viewmodel


class WikiInfo {
    var summary: String? = null
    var elevation = 0
    var latitude = 0.0
    var longitude = 0.0
    var rank = 0
    var thumbnailImg: String? = null
    var lang: String? = null
    var title: String? = null
    var wikipediaUrl: String? = null
    var geoNameId = 0
    var countryCode: String? = null
    var feature: String? = null

    override fun toString() = "Title:${title}, Summary:${summary?.substring(0, 5)}..., $longitude, $latitude"
}