package org.csystem.android.app.basicviews

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
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

    private fun getBirthDate() : LocalDate
    {
        val year = mBinding.mainActivityEditTextYear.text.toString().toInt()
        val month = mBinding.mainActivityEditTextMonth.text.toString().toInt()
        val day = mBinding.mainActivityEditTextDay.text.toString().toInt()

        return LocalDate.of(year, month, day)
    }

    private fun getRegisterInfo() : RegisterInfo?
    {
        val password = mBinding.mainActivityEditTextPassword.text.toString()
        if (!confirm(password, mBinding.mainActivityEditTextConfirmPassword.text.toString()))
            return null

        val name = mBinding.mainActivityEditTextName.text.toString()
        val email = mBinding.mainActivityEditTextEmail.text.toString()
        val birthDate = getBirthDate()
        val userName = mBinding.mainActivityEditTextUserName.text.toString()

        return RegisterInfo(name, email, birthDate, userName, password)
    }

    private fun registerButtonClickedCallback()
    {
        try {
           val registerInfo = getRegisterInfo()

           if (registerInfo != null) {
               Toast.makeText(this, registerInfo.toString(), Toast.LENGTH_LONG).show()
               mBinding.mainmActivityTextViewInformation.text = registerInfo.toString()
           }
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

    private fun clearEditTexts()
    {
        mBinding.mainActivityEditTextPassword.setText("")
        for (view in mBinding.mainActivityLinearLayoutMain.children) {
            if (view is EditText)
                view.setText("")
        }
        mBinding.mainmActivityTextViewInformation.text = ""
    }

    private fun clearButtonClickedCallback()
    {
        clearEditTexts()
        initBirthDateTexts()
        mBinding.mainActivityCheckboxAcceptConditions.isChecked = false
        with (mBinding.mainActivityEditTextPassword) {
            inputType = INPUT_TYPE_TEXT_PASSWORD_HIDE
            mBinding.mainActivityButtonShowPassword.setText(R.string.button_show_password_text)
            tag = false
        }

        mBinding.mainActivityEditTextName.requestFocus()
    }


    private fun showPasswordButtonClickedCallback()
    {
        with(mBinding.mainActivityButtonShowPassword) {
            val show = tag as Boolean
            val resId =
                if (show) R.string.button_hide_password_text else R.string.button_show_password_text

            setText(resId)
            mBinding.mainActivityEditTextPassword.inputType =
                if (show) INPUT_TYPE_TEXT_PASSWORD_SHOW else INPUT_TYPE_TEXT_PASSWORD_HIDE
            tag = !show
        }
    }

    private fun initShowPasswordButton()
    {
        mBinding.mainActivityButtonShowPassword.apply {
            tag = true
            setOnClickListener { showPasswordButtonClickedCallback() }
        }
    }

    private fun initRegisterButton()
    {
        mBinding.mainActivityButtonRegister.apply { setOnClickListener { registerButtonClickedCallback() }}
    }

    private fun initCloseButton()
    {
        mBinding.mainActivityButtonClose.apply { setOnClickListener { closeButtonClickedCallback() }}
    }

    private fun initClearButton()
    {
        mBinding.mainActivityButtonClear.apply { setOnClickListener { clearButtonClickedCallback() }}
    }

    private fun initBirthDateTexts()
    {
        val today = LocalDate.now()

        mBinding.mainActivityEditTextDay.setText(today.dayOfMonth.toString())
        mBinding.mainActivityEditTextMonth.setText(today.monthValue.toString())
        mBinding.mainActivityEditTextYear.setText(today.year.toString())
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.registerInfoViewModel = RegisterInfo()
    }

    private fun initViews()
    {
        initBinding()
        initBirthDateTexts()
        initShowPasswordButton()
        initRegisterButton()
        initClearButton()
        initCloseButton()
        //initAcceptCheckBox()
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