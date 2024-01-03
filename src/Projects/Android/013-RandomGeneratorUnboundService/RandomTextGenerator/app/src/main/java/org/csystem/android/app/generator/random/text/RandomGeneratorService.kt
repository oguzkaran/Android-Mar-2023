package org.csystem.android.app.generator.random.text

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class RandomGeneratorService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show()
        //Tipik olarak bir asenkron oluşturulur

        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy()
    {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder
    {
        throw UnsupportedOperationException("Unsupported ")
    }
}