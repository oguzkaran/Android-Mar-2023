package org.csystem.android.app.basicviews

import android.os.Bundle
import android.text.InputType
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.csystem.android.app.basicviews.databinding.ActivityMainBinding
import org.csystem.android.app.basicviews.global.alert.promptDecision
import org.csystem.android.app.basicviews.global.alert.promptNotConfirmedDialog
import org.csystem.android.app.basicviews.viewmodel.RegisterInfo
import java.time.DateTimeException
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private fun neutralButtonClickedCallback()
    {
        mBinding.mainActivityEditTextConfirmPassword.setText("")
    }

    private fun positiveButtonClickedCallback()
    {
        finish()
    }

    private fun negativeButtonClickedCallback()
    {
        Toast.makeText(this, R.string.message_continue, Toast.LENGTH_SHORT).show()
    }

    private fun confirm(password: String, confirmPassword: String) : Boolean
    {
        var result = true

        if (password != confirmPassword) {
            promptNotConfirmedDialog(this, R.string.confirm_alert_dialog_title,
                R.string.message_password_not_confirmed, R.string.ok_button_text) {_, _ -> neutralButtonClickedCallback()}
            Toast.makeText(this, R.string.message_password_not_confirmed, Toast.LENGTH_LONG).show()
            result = false
        }

        return result
    }

    private fun getRegisterInfo() : RegisterInfo?
    {
        val password = mBinding.mainActivityEditTextPassword.text.toString()
        if (!confirm(password, mBinding.mainActivityEditTextConfirmPassword.text.toString()))
            return null

        val name = mBinding.mainActivityEditTextName.text.toString()
        val email = mBinding.mainActivityEditTextEmail.text.toString()
        val birthDate = LocalDate.of(mBinding.mainActivityEditTextYear.text.toString().toInt(),
            mBinding.mainActivityEditTextMonth.text.toString().toInt(), mBinding.mainActivityEditTextDay.text.toString().toInt())
        val userName = mBinding.mainActivityEditTextUserName.text.toString()

        return RegisterInfo(name, email, birthDate, userName, password)
    }

    private fun registerButtonClickedCallback()
    {
        try {
           val registerInfo = getRegisterInfo()

           if (registerInfo != null)
                Toast.makeText(this, registerInfo.toString(), Toast.LENGTH_LONG).show()
        }
        catch (ignore: NumberFormatException) {
            Toast.makeText(this, R.string.message_number_format_exception, Toast.LENGTH_LONG).show()
        }
        catch (ignore: DateTimeException) {
           Toast.makeText(this, R.string.message_datetime_exception, Toast.LENGTH_LONG).show()
        }
    }

    private fun closeButtonClickedCallback()
    {
        promptDecision(this, R.string.confirm_close_alert_dialog_title, R.string.message_confirm_close,
            R.string.yes_button_text, R.string.no_button_text,
            {_, _ -> positiveButtonClickedCallback()}) {_, _ -> negativeButtonClickedCallback()}
    }

    private fun initRegisterButton()
    {
        mBinding.mainActivityButtonRegister.apply { setOnClickListener { registerButtonClickedCallback() }}
    }

    private fun initCloseButton()
    {
        mBinding.mainActivityButtonClose.apply { setOnClickListener { closeButtonClickedCallback() }}

    }

    private fun initAcceptCheckBox()
    {
        findViewById<CheckBox>(R.id.mainActivityCheckboxAcceptConditions)
            .apply { setOnCheckedChangeListener{_, checked -> mBinding.mainActivityButtonRegister.isEnabled = checked}}
    }

    private fun initBinding()
    {
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    private fun initViews()
    {
        initBinding()
        initRegisterButton()
        initCloseButton()
        initAcceptCheckBox()
    }

    private fun initialize()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }
}