package org.csystem.android.app.activitylifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, R.string.on_create_message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart()
    {
        Toast.makeText(this, R.string.on_start_message, Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onRestart()
    {
        Toast.makeText(this, R.string.on_restart_message, Toast.LENGTH_SHORT).show()
        super.onRestart()
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