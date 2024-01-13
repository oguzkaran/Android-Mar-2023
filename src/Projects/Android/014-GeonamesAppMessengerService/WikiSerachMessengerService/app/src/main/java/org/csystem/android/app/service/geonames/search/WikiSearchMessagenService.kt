package org.csystem.android.app.service.geonames.search

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.service.geonames.search.api.IGeonamesWikiSearchService
import org.csystem.android.app.service.geonames.search.api.WikiSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.format.DateTimeFormatter
import java.util.concurrent.ExecutorService
import javax.inject.Inject

@AndroidEntryPoint
class WikiSearchMessagenService : Service() {
    @Inject
    lateinit var wikiSearchService: IGeonamesWikiSearchService

    @Inject
    lateinit var dateTimeFormatter : DateTimeFormatter

    @Inject
    lateinit var threadPool : ExecutorService


    override fun onBind(intent: Intent): IBinder
    {
        TODO("Return the communication channel to the service.")
    }

    fun getButtonClicked()
    {

        val call = wikiSearchService.findByQ("zonguldak", 10, "csystem")

        call.enqueue(object: Callback<WikiSearch> {
            override fun onResponse(call: Call<WikiSearch>, response: Response<WikiSearch>)
            {
                val wikiSearch = response.body()

                if (wikiSearch?.wikiInfo != null) {
                    wikiSearch.wikiInfo.forEach {  }
                }
                else
                    Toast.makeText(this@WikiSearchMessagenService, "Error in geonames service", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<WikiSearch>, ex: Throwable)
            {
                Toast.makeText(this@WikiSearchMessagenService, "Exception occurred:${ex.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}