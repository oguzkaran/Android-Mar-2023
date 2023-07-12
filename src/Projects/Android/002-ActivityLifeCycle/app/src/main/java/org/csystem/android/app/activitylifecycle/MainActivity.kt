package org.csystem.android.app.activitylifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun displayInitMessage(bundle: Bundle?)
    {
        val message = if (bundle == null) "First Created" else "Re created by system"

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        displayInitMessage(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, R.string.on_create_message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart()
    {
        Toast.makeText(this, R.string.on_start_message, Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onResume()
    {
        Toast.makeText(this, R.string.on_resume_message, Toast.LENGTH_SHORT).show()
        super.onResume()
    }

    override fun onRestart()
    {
        Toast.makeText(this, R.string.on_restart_message, Toast.LENGTH_SHORT).show()
        super.onRestart()
    }

    override fun onPause()
    {
        Toast.makeText(this, R.string.on_pause_message, Toast.LENGTH_SHORT).show()
        super.onPause()
    }
    override fun onStop()
    {
        Toast.makeText(this, R.string.on_stop_message, Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onDestroy()
    {
        Toast.makeText(this, R.string.on_destroy_message, Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}