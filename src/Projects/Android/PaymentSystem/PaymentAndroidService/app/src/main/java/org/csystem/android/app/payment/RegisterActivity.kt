package org.csystem.android.app.payment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karandev.util.data.service.DataServiceException
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.payment.constant.what.register.WHAT_REGISTER_BIRTHDATE_INVALID
import org.csystem.android.app.payment.constant.what.register.WHAT_REGISTER_DATA_SERVICE_EXCEPTION
import org.csystem.android.app.payment.constant.what.register.WHAT_REGISTER_EXCEPTION
import org.csystem.android.app.payment.constant.what.register.WHAT_REGISTER_SUCCESS
import org.csystem.android.app.payment.constant.what.register.WHAT_REGISTER_USER_NOT_REGISTERED
import org.csystem.android.app.payment.data.service.PaymentApplicationDataService
import org.csystem.android.app.payment.data.service.dto.UserSaveDTO
import org.csystem.android.app.payment.databinding.ActivityRegisterBinding
import org.csystem.android.app.payment.viewmodel.RegisterActivityListenerViewModel
import java.lang.ref.WeakReference
import java.time.LocalDate
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mHandler: Handler

    @Inject
    lateinit var dataService: PaymentApplicationDataService

    @Inject
    lateinit var threadPool: ScheduledExecutorService

    private class RegisterHandler(activity: RegisterActivity) : Handler(Looper.myLooper()!!) {
        private val mWeakReference = WeakReference(activity)
        
        private fun handleUserNotRegistered()
        {
            val activity = mWeakReference.get()!!

            Toast.makeText(activity, "$${activity.mBinding.user!!.username} can not be registered", Toast.LENGTH_LONG).show()
        }

        private fun handleRegisterSuccess()
        {
            val activity = mWeakReference.get()!!

            Toast.makeText(activity, "${activity.mBinding.user!!.username} successfully registered", Toast.LENGTH_LONG).show()
            Intent(activity, LoginActivity::class.java).apply {activity.startActivity(this)}
            activity.finish()
        }

        override fun handleMessage(msg: Message)
        {
            val activity = mWeakReference.get()!!

            when (msg.what) {
                WHAT_REGISTER_BIRTHDATE_INVALID -> Toast.makeText(activity, "Invalid date format", Toast.LENGTH_LONG).show()
                WHAT_REGISTER_USER_NOT_REGISTERED -> handleUserNotRegistered()
                WHAT_REGISTER_DATA_SERVICE_EXCEPTION -> Toast.makeText(activity, "Data problem:${msg.obj}", Toast.LENGTH_LONG).show()
                WHAT_REGISTER_EXCEPTION -> Toast.makeText(activity, "Problem occurred. Try again later", Toast.LENGTH_LONG).show()
                WHAT_REGISTER_SUCCESS ->handleRegisterSuccess()
            }
        }
    }

    private fun registerButtonClickedCallback()
    {
        try {
            val user = mBinding.user!!

            if (user.birthDate == LocalDate.now()) {
                mHandler.sendEmptyMessage(WHAT_REGISTER_BIRTHDATE_INVALID)
                return
            }

            if (dataService.saveUser(user))
                mHandler.sendEmptyMessage(WHAT_REGISTER_SUCCESS)
            else
                mHandler.sendEmptyMessage(WHAT_REGISTER_USER_NOT_REGISTERED)
        }
        catch (ex: DataServiceException) {
            mHandler.sendMessage(mHandler.obtainMessage(WHAT_REGISTER_DATA_SERVICE_EXCEPTION, ex.message))
        }
        catch (ignore: Throwable) {
            mHandler.sendEmptyMessage(WHAT_REGISTER_EXCEPTION)
        }
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        mBinding.viewModel = RegisterActivityListenerViewModel(this)
        mBinding.user = UserSaveDTO()
    }
    private fun initialize()
    {
        initBinding()
        mHandler = RegisterHandler(this)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun registerButtonClicked() = threadPool.execute{registerButtonClickedCallback()}

    fun closeButtonClicked()
    {
        AlertDialog.Builder(this)
            .setTitle(R.string.alertdialog_register_title_text)
            .setMessage(R.string.alertdialog_register_message_text)
            .setPositiveButton(R.string.alertdialog_register_yes_button_text) {_, _ -> finish()}
            .setNegativeButton(R.string.alertdialog_register_no_button_text) {_, _ ->}
            .create().show()
    }
}