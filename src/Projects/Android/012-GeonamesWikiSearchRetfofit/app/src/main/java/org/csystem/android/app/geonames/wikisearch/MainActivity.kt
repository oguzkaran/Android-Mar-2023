package org.csystem.android.app.geonames.wikisearch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.geonames.wikisearch.api.IGeonamesWikiSearchService
import org.csystem.android.app.geonames.wikisearch.api.WikiInfo
import org.csystem.android.app.geonames.wikisearch.api.WikiSearch
import org.csystem.android.app.geonames.wikisearch.databinding.ActivityMainBinding
import org.csystem.android.app.geonames.wikisearch.viewmodel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var wikiSearchService: IGeonamesWikiSearchService

    private fun initData()
    {
        mBinding.viewModel = MainActivityViewModel(this)
        mBinding.wikiInfoAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayList<WikiInfo>())
        mBinding.q = "zonguldak"
        mBinding.maxRows = 10
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initData()
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

    fun getButtonClicked()
    {
        mBinding.wikiInfoAdapter!!.clear()
        val call = wikiSearchService.findByQ(mBinding.q!!, mBinding.maxRows!!, "csystem")

        call.enqueue(object: Callback<WikiSearch> {
            override fun onResponse(call: Call<WikiSearch>, response: Response<WikiSearch>)
            {
                val wikiSearch = response.body()

                if (wikiSearch?.wikiInfo != null) {
                    wikiSearch.wikiInfo.forEach { mBinding.wikiInfoAdapter!!.add(it) }
                    mBinding.wikiInfoAdapter!!.notifyDataSetChanged()
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