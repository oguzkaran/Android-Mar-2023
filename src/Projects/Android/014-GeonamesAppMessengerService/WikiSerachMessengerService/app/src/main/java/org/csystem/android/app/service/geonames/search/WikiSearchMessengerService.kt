package org.csystem.android.app.service.geonames.search

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.service.geonames.search.api.IGeonamesWikiSearchService
import org.csystem.android.app.service.geonames.search.api.WikiInfo
import org.csystem.android.app.service.geonames.search.api.WikiSearch
import org.csystem.android.library.service.search.wiki.common.Common
import retrofit2.Call
import retrofit2.Response
import java.lang.ref.WeakReference
import java.time.format.DateTimeFormatter
import java.util.concurrent.ExecutorService
import javax.inject.Inject


@AndroidEntryPoint
class WikiSearchMessengerService : Service() {
    private lateinit var mMessenger: Messenger
    private lateinit var mHandler: Handler

    @Inject
    lateinit var wikiSearchService: IGeonamesWikiSearchService

    @Inject
    lateinit var dateTimeFormatter : DateTimeFormatter

    @Inject
    lateinit var threadPool : ExecutorService

    private class WikiSearchHandler(service: WikiSearchMessengerService) : Handler(Looper.myLooper()!!) {
        private val mWeakReference = WeakReference(service)

        private fun replyCallback(wikiInfo: WikiInfo, replyTo: Messenger)
        {
            val replyMessage = Message.obtain(null, Common.WHAT_WIKI_REPLY)

            replyMessage.data.putString(Common.BUNDLE_KEY_REPLY, wikiInfo.summary)
            replyTo.send(replyMessage)
        }

        private fun wikiSearchCallback(msg: Message, replyTo: Messenger)
        {
            val text = msg.data.getString(Common.BUNDLE_KEY_TEXT)!!
            val maxRows = msg.data.getInt(Common.BUNDLE_KEY_MAX_ROWS)
            val service = mWeakReference.get()!!
            val wikiService = service.wikiSearchService
            val call = wikiService.findByQ(text, maxRows, "csystem")

            call.enqueue(object: retrofit2.Callback<WikiSearch> {
                override fun onResponse(call: Call<WikiSearch>, response: Response<WikiSearch>)
                {
                    val wikiSearch = response.body()

                    if (wikiSearch?.wikiInfo != null)
                        if (wikiSearch.wikiInfo.isNotEmpty())
                            wikiSearch.wikiInfo.forEach{replyCallback(it, replyTo)}
                        else
                            Toast.makeText(service, "Not found", Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(service, "Error in geonames service", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<WikiSearch>, ex: Throwable)
                {
                    Toast.makeText(service, "Exception occurred:${ex.message}", Toast.LENGTH_LONG).show()
                }
            })
        }

        override fun handleMessage(msg: Message)
        {
            val replyTo = msg.replyTo

            when (msg.what) {
                Common.WHAT_WIKI_SEARCH -> wikiSearchCallback(msg, replyTo)
            }
            super.handleMessage(msg)
        }
    }

    override fun onBind(intent: Intent): IBinder
    {
        Toast.makeText(this, "Client bound!...", Toast.LENGTH_LONG).show()

        mHandler = WikiSearchHandler(this)
        mMessenger = Messenger(mHandler)

        return mMessenger.binder
    }
}