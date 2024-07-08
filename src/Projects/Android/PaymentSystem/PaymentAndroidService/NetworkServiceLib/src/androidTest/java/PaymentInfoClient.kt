
import com.karandev.util.net.TcpUtil
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.net.Socket
import javax.inject.Inject

const val HOST = "161.97.141.113"
const val PORT = 50540

class PaymentInfoClient @Inject constructor() {
    private fun socketConnect(id : Byte) : String
    {
        var msg : String

        try {
            Socket(HOST, PORT).use {
                TcpUtil.sendByte(it, id)
                val status = TcpUtil.receiveByte(it)
                msg = statusMessage(status, it)
            }
        }
        catch (ex : IOException) {
            throw IOException("socketConnect IoException failed")
        }
        catch (ex : Throwable) {
            throw  Throwable("socketConnect Throwable  failed")
        }
        return msg
    }

    private fun statusMessage(status : Byte, socket: Socket ) : String
    {
        try {
            return if (status == 1.toByte())
                TcpUtil.receiveStringViaLength(socket)
            else if (status == 0.toByte())
                "yanlış bilgi"
            else
                 "Bilinmeyen bir hata oluştu"
        }
        catch (ex : IOException) {
            throw IOException("statusMessage IoException")
        }
        catch (ex : Throwable) {
            throw Throwable("statusMessage ThrowableException")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun run(id : Byte) : String
    {
        var msg : String = ""
        runBlocking {
            GlobalScope.launch {
                msg = socketConnect(id)
            }
        }

        return msg
    }
}