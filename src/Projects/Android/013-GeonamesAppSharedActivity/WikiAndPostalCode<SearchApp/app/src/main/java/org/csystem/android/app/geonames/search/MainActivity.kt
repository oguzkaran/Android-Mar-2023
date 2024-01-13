package org.csystem.android.app.geonames.search

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint

import org.csystem.android.app.geonames.search.api.IGeonamesWikiSearchService
import org.csystem.android.app.geonames.search.api.WikiInfo
import org.csystem.android.app.geonames.search.api.WikiSearch
import org.csystem.android.app.geonames.search.databinding.ActivityMainBinding
import org.csystem.android.app.geonames.search.viewmodel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ExecutorService
import javax.inject.Inject

const val SHARED_PREF_FILE_NAME = "geonames-input"
const val LAST_OPEN_BEFORE = "LAST_OPEN_BEFORE"
const val Q = "Q"
const val MAX_ROWS = "MAX_ROWS"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val mWikiInfo =  ArrayList<WikiInfo>()

    @Inject
    lateinit var wikiSearchService: IGeonamesWikiSearchService

    @Inject
    lateinit var dateTimeFormatter : DateTimeFormatter

    @Inject
    lateinit var threadPool : ExecutorService

    private fun saveData(data: String?, bw: BufferedWriter)
    {
        try {
            bw.write("$data\r\n")
            bw.flush()
        }
        catch (ex: IOException) {
            runOnUiThread{Toast.makeText(this, "IO Error while saving:${ex.message}", Toast.LENGTH_LONG).show()}
        }
    }

    private fun saveCache(bw: BufferedWriter)
    {
        val count = mWikiInfo.size

        for (i in 1..<count)
            saveData(mWikiInfo[i].summary, bw)
    }

    private fun saveCacheCallback()
    {
        try {
            BufferedWriter(OutputStreamWriter(FileOutputStream(File(cacheDir, "data.dat")))).use(this::saveCache)
        }
        catch (ex: IOException) {
            runOnUiThread{Toast.makeText(this, "IO Error while opening:${ex.message}", Toast.LENGTH_LONG).show()}
        }
    }

    private fun loadData()
    {
        val sharedPrefs = getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        val prefs = getPreferences(MODE_PRIVATE)

        mBinding.lastOpenBefore = "Last Open:${prefs.getString(LAST_OPEN_BEFORE, "")}"
        mBinding.q = sharedPrefs.getString(Q, "zonguldak")
        mBinding.maxRows = sharedPrefs.getInt(MAX_ROWS, 10)
    }
    private fun initData()
    {
        val q = intent.getStringExtra("Q")

        if (q != null) {
            mBinding.q = q
            mBinding.maxRows = intent.getIntExtra("MAX_ROWS", 0)
        }
        else
            loadData()
    }

    private fun initBoundData()
    {
        mBinding.viewModel = MainActivityViewModel(this)
        mBinding.wikiInfoAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mWikiInfo)
        initData()
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initBoundData()
    }

    private fun initialize()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onDestroy()
    {
        val editorPrefs = getPreferences(MODE_PRIVATE).edit()
        val editorSharedPrefs = getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE).edit()

        editorSharedPrefs.putString(Q, mBinding.q)
        editorSharedPrefs.putInt(MAX_ROWS, mBinding.maxRows)
        editorSharedPrefs.apply() //apply asenkron kaydeder. Senkron kaydetmek için commit metodu çağrılabilir

        editorPrefs.putString(LAST_OPEN_BEFORE, dateTimeFormatter.format(LocalDateTime.now()))
        editorPrefs.apply()
        super.onDestroy()
    }

    fun getButtonClicked()
    {
        mBinding.wikiInfoAdapter!!.clear()
        val call = wikiSearchService.findByQ(mBinding.q!!, mBinding.maxRows, "csystem")

        call.enqueue(object: Callback<WikiSearch> {
            override fun onResponse(call: Call<WikiSearch>, response: Response<WikiSearch>)
            {
                val wikiSearch = response.body()

                if (wikiSearch?.wikiInfo != null) {
                    wikiSearch.wikiInfo.forEach { mBinding.wikiInfoAdapter!!.add(it) }
                    mBinding.wikiInfoAdapter!!.notifyDataSetChanged()
                    threadPool.execute{saveCacheCallback()}
                }
                else
                    Toast.makeText(this@MainActivity, "Error in service", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<WikiSearch>, ex: Throwable)
            {
                Toast.makeText(this@MainActivity, "Exception occurred:${ex.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}