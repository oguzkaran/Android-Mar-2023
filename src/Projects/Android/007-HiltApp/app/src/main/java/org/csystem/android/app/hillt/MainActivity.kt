package org.csystem.android.app.hillt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.hillt.datetime.DateInfo
import org.csystem.android.app.hillt.datetime.DateTimeInfo
import org.csystem.android.app.hillt.datetime.TimeInfo
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var dateTimeInfo: DateTimeInfo

    @Inject
    lateinit var dateInfo: DateInfo

    @Inject
    lateinit var timeInfo: TimeInfo

    private fun showDateTime()
    {
        val sb = StringBuilder()

        sb.append("DateTime:").append(dateTimeInfo.toString()).append("\n")
            .append("Date:").append(dateInfo.toString()).append("\n")
            .append("Time:").append(timeInfo.toString())

        Toast.makeText(this, sb, Toast.LENGTH_LONG).show()
    }

    private fun initialize()
    {
        setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onResume()
    {
        showDateTime()
        super.onResume()
    }
}