package org.csystem.android.app.generator.random.text

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.generator.random.text.data.RandomTextGeneratorInfo
import org.csystem.android.app.generator.random.text.global.RANDOM_TEXT_GENERATOR_INFO
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.lang.ref.WeakReference
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import kotlin.random.Random


const val WHAT_EXCEPTION = -1
const val WHAT_IO_EXCEPTION = -2

@AndroidEntryPoint
class RandomGeneratorService : Service() {
    private lateinit var mHandler: RandomGeneratorHandler

    @Inject
    lateinit var threadPool: ExecutorService

    @Inject
    lateinit var dateTime: LocalDateTime

    @Inject
    lateinit var dateTimeFormatter: DateTimeFormatter

    private class RandomGeneratorHandler(service: RandomGeneratorService) : Handler(Looper.myLooper()!!) {
        private val mWeakReference = WeakReference(service)
        override fun handleMessage(msg: Message)
        {
            val service = mWeakReference.get()!!
            when (msg.what) {
                WHAT_IO_EXCEPTION -> Toast.makeText(service, "IO Problem:${msg.obj}", Toast.LENGTH_LONG).show()
                WHAT_EXCEPTION -> Toast.makeText(service, "Problem:${msg.obj}", Toast.LENGTH_LONG).show()
                //...
            }

            super.handleMessage(msg)
        }
    }

    private fun getRandomTextGeneratorInfo(intent: Intent?) : RandomTextGeneratorInfo
    {
        return intent?.getSerializableExtra(RANDOM_TEXT_GENERATOR_INFO) as RandomTextGeneratorInfo
    }

    private fun createRandoText(count: Int, random: Random = Random) : String
    {
        val sb = StringBuilder(count)

        generateSequence(0) {it + 1}.takeWhile { it < count }
            .forEach { _ -> sb.append((if (random.nextBoolean()) 'A' else 'a') + random.nextInt(26))  }

        return sb.toString()
    }

    private fun randomGeneratorOutputForEachCallback(info: RandomTextGeneratorInfo, bw: BufferedWriter)
    {
        try {
            bw.run {
                write(
                    "${
                        createRandoText(
                            Random.nextInt(
                                info.min,
                                info.bound
                            )
                        )
                    } ${dateTimeFormatter.format(dateTime)}"
                ); newLine(); flush()
            }
            Thread.sleep(Random.nextLong(300, 1000))
        }
        catch (ex: IOException) {
            mHandler.sendMessage(mHandler.obtainMessage(WHAT_IO_EXCEPTION, ex.message))
        }

        catch (ex: Throwable) {
            mHandler.sendMessage(mHandler.obtainMessage(WHAT_EXCEPTION, ex.message))
        }
    }
    private fun randomGeneratorOutputCallback(info: RandomTextGeneratorInfo, bw: BufferedWriter)
    {
        generateSequence(0) {it + 1}.takeWhile { it < info.count }
            .forEach{_-> randomGeneratorOutputForEachCallback(info, bw)}
    }

    private fun randomGeneratorCallback(info: RandomTextGeneratorInfo)
    {
        try {
            //...
            openFileOutput(info.fileName, MODE_APPEND)
                .use { BufferedWriter(OutputStreamWriter(it, StandardCharsets.UTF_8)).apply{randomGeneratorOutputCallback(info, this)} }

            //stopSelf()
        }
        catch (ex: IOException) {
            mHandler.sendMessage(mHandler.obtainMessage(WHAT_IO_EXCEPTION, ex.message))
        }
        catch (ex: Throwable) {
            mHandler.sendMessage(mHandler.obtainMessage(WHAT_EXCEPTION, ex.message))
        }
    }

    private fun initialize(intent: Intent?)
    {
        mHandler = RandomGeneratorHandler(this)
        threadPool.execute{randomGeneratorCallback(getRandomTextGeneratorInfo(intent))}
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show()
        initialize(intent)

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