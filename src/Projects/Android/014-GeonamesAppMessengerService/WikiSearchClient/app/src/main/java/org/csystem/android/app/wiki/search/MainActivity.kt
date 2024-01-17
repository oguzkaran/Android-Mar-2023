package org.csystem.android.app.wiki.search

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.DeadObjectException
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.wiki.search.databinding.ActivityMainBinding
import org.csystem.android.app.wiki.search.viewmodel.MainActivityViewModel
import org.csystem.android.app.wiki.search.viewmodel.WikiInfo
import org.csystem.android.library.service.search.wiki.WikiSearchInfo
import org.csystem.android.library.service.search.wiki.common.Common
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
    private var mRequestMessenger: Messenger? = null
    private var mReplyMessenger: Messenger? = null
    private var mBound = false

    private val mWikiServiceConnection = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?)
        {
            mRequestMessenger = Messenger(service)
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?)
        {
            mRequestMessenger = null
            mReplyMessenger = null
            mBound = false
        }
    }

    private val mWikiInfo =  ArrayList<WikiInfo>()

    @Inject
    lateinit var dateTimeFormatter : DateTimeFormatter

    private fun bindWikiSearchService()
    {
        val intent = Intent(Common.WIKI_SEARCH_SERVICE_ACTION_NAME).setPackage(Common.WIKI_SEARCH_SERVICE_PACKAGE_NAME)

        if (!bindService(intent, mWikiServiceConnection, Context.BIND_AUTO_CREATE))
            throw RemoteException("Bind problem!...")
    }

    private  fun unbindWikiSearchService()
    {
        if (mBound) {
            unbindService(mWikiServiceConnection)
            mBound = false
            mRequestMessenger = null
            mReplyMessenger = null
        }
    }

    private fun sendData()
    {
        try {
            val message = Message.obtain(null, Common.WHAT_WIKI_SEARCH)

            message.data.putInt("MAX", mBinding.maxRows)
            message.data.putString("TEXT", mBinding.q)

            //message.replyTo = mReplyMessenger
            mRequestMessenger?.send(message)
        }
        catch (ex: DeadObjectException) {
            Log.d("dead-object-ex", ex.message ?: "Dead Object!!..")
            Toast.makeText(this, "Connection problem!...", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Log.d("send-ex", ex.message ?: "General roblem occurred!!..")
            Toast.makeText(this, "Problem occurred!...", Toast.LENGTH_LONG).show()
        }
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

    override fun onStart()
    {
        try {
            bindWikiSearchService()
        }
        catch (ex: RemoteException) {
            Log.d("bind-service", ex.message ?: "Bind problem occurred!!..")
            Toast.makeText(this, "Remote problem!...", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Log.d("bind-service_ex", ex.message ?: "General roblem occurred!!..")
            Toast.makeText(this, "Problem occurred!...", Toast.LENGTH_LONG).show()
        }
        super.onStart()
    }

    override fun onStop()
    {
        try {
            unbindWikiSearchService()
        }
        catch (ex: RemoteException) {
            Log.d("unbind-service", ex.message ?: "Unbind problem occurred!!..")
            Toast.makeText(this, "Remote problem!...", Toast.LENGTH_LONG).show()
        }
        catch (ex: Throwable) {
            Log.d("unbind-service_ex", ex.message ?: "General roblem occurred!!..")
            Toast.makeText(this, "Problem occurred!...", Toast.LENGTH_LONG).show()
        }
        super.onStop()
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
        try {
            if (mBound)
                sendData()
        }
        catch (ex: Throwable) {
            Log.d("search-ex", ex.message ?: "General roblem occurred!!..")
            Toast.makeText(this, "Problem occurred. Please try again later!...", Toast.LENGTH_LONG).show()
        }
    }
}