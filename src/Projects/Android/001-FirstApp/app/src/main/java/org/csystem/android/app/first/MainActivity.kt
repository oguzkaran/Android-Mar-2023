package org.csystem.android.app.first

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private fun displayDateTime()
    {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss")

        Toast.makeText(this, formatter.format(now), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayDateTime()
    }
}