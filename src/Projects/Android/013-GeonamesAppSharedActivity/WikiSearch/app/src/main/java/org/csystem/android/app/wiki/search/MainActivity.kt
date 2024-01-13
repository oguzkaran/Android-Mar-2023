package org.csystem.android.app.wiki.search

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.wiki.search.databinding.ActivityMainBinding
import org.csystem.android.app.wiki.search.viewmodel.MainActivityViewModel
import org.csystem.android.app.wiki.search.viewmodel.WikiInfo
import java.io.BufferedWriter
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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
    lateinit var dateTimeFormatter : DateTimeFormatter

    private fun startActivityApplyCallback(intent: Intent)
    {
        startActivity(intent.putExtra("Q", mBinding.q!!).putExtra("MAX_ROWS", mBinding.maxRows))
    }

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

    private fun loadData()
    {
        val sharedPrefs = getSharedPreferences(SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        val prefs = getPreferences(MODE_PRIVATE)

        mBinding.lastOpenBefore = "Last Open:${prefs.getString(LAST_OPEN_BEFORE, "")}"
        mBinding.q = sharedPrefs.getString(Q, "zonguldak")
        mBinding.maxRows = sharedPrefs.getInt(MAX_ROWS, 10)
    }

    private fun initBoundData()
    {
        mBinding.viewModel = MainActivityViewModel(this)
        loadData()
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
        editorSharedPrefs.apply()

        editorPrefs.putString(LAST_OPEN_BEFORE, dateTimeFormatter.format(LocalDateTime.now()))
        editorPrefs.apply()
        super.onDestroy()
    }

    fun searchButtonClicked()
    {
        Intent("org.csystem.app.geonames.search.WIKI").apply { startActivityApplyCallback(this)}
    }
}