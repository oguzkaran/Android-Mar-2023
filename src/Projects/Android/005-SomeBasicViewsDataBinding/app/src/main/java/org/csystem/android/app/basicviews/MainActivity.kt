package org.csystem.android.app.basicviews

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import org.csystem.android.app.basicviews.databinding.ActivityMainBinding
import org.csystem.android.app.basicviews.global.alert.promptDecision
import org.csystem.android.app.basicviews.global.alert.promptNotConfirmedDialog
import org.csystem.android.app.basicviews.viewmodel.MainActivityViewModel
import org.csystem.android.app.basicviews.viewmodel.RegisterInfo
import java.time.DateTimeException
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private fun neutralButtonClickedCallback()
    {
        mBinding.confirmPassword = ""
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
        if (!confirm(mBinding.password!!, mBinding.confirmPassword!!))
            return null

        val name = mBinding.registerInfoViewModel!!.name
        val email = mBinding.registerInfoViewModel!!.email
        val birthDate = LocalDate.of(mBinding.year!!.toInt(), mBinding.month!!.toInt(), mBinding.day!!.toInt())
        val userName = mBinding.registerInfoViewModel!!.userName

        return RegisterInfo(name, email, birthDate, userName, mBinding.password!!)
    }

    private fun clearEditTexts()
    {
        mBinding.password = ""
        for (view in mBinding.mainActivityLayoutRegisterInfo.children)
            if (view is EditText)
                view.setText("")

        mBinding.confirmPassword = ""
    }

    private fun setRegisterInfoVisibility(visibility: Int)
    {
        for (view in mBinding.mainActivityLayoutRegisterInfo.children)
            view.visibility = visibility
    }

    private fun initBirthDateTexts()
    {
        val today = LocalDate.now()

        mBinding.day = today.dayOfMonth.toString()
        mBinding.month = today.monthValue.toString()
        mBinding.year = today.year.toString()
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.registerInfoViewModel = RegisterInfo()
        mBinding.mainActivityViewModel = MainActivityViewModel(this)
        mBinding.show = true
        mBinding.passwordInputType = INPUT_TYPE_TEXT_PASSWORD_HIDE
        mBinding.showPasswordButtonText = resources.getString(R.string.button_show_password_text)
    }

    private fun initViews()
    {
        initBinding()
        initBirthDateTexts()
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

    private fun allowClosePositiveButtonClickedCallback(checked: Boolean)
    {
        clearButtonClicked()
        setRegisterInfoVisibility(View.GONE)
    }

    private fun allowCShowPasswordNegativeButtonClickedCallback()
    {
        mBinding.allowShowPasswordChecked = false
    }

    fun openToggleButtonCheckedChanged(checked: Boolean)
    {
        if (!checked)
            AlertDialog.Builder(this).setTitle(R.string.confirm_alert_dialog_title)
                .setMessage(R.string.message_confirm_close)
                .setPositiveButton(R.string.yes_button_text) {_, _-> allowClosePositiveButtonClickedCallback(checked) }
                .setNegativeButton(R.string.no_button_text) {_, _ -> mBinding.mainActivityToggleButtonOpen.performClick()}
                .setOnCancelListener{mBinding.mainActivityToggleButtonOpen.performClick()}
                .create()
                .show()
        else
            setRegisterInfoVisibility(View.VISIBLE)
    }

    fun allowShowPasswordSwitchCheckedChanged(checked: Boolean)
    {
        if (!checked)
            return

        AlertDialog.Builder(this).setTitle(R.string.confirm_alert_dialog_title)
            .setMessage(R.string.message_enable_show_password)
            .setPositiveButton(R.string.yes_button_text) {_, _->  }
            .setNegativeButton(R.string.no_button_text) {_, _ -> allowCShowPasswordNegativeButtonClickedCallback() }
            //.setNeutralButton("") {_, _ -> mBinding.allowShowPasswordChecked = false}
            .setOnCancelListener{mBinding.allowShowPasswordChecked = false}
            .create()
            .show()
    }

    fun showPasswordButtonClicked()
    {
        val show = mBinding.show as Boolean
        val resId = if (show) R.string.button_hide_password_text else R.string.button_show_password_text

        mBinding.showPasswordButtonText = resources.getString(resId)
        mBinding.passwordInputType = if (show) INPUT_TYPE_TEXT_PASSWORD_SHOW else INPUT_TYPE_TEXT_PASSWORD_HIDE
        mBinding.show = !show
    }

    fun registerButtonClicked()
    {
        try {
            val registerInfo = getRegisterInfo()

            if (registerInfo != null) {
                Toast.makeText(this, registerInfo.toString(), Toast.LENGTH_LONG).show()
                mBinding.result = registerInfo.toString()
            }
        }
        catch (ignore: NumberFormatException) {
            Toast.makeText(this, R.string.message_number_format_exception, Toast.LENGTH_LONG).show()
        }
        catch (ignore: DateTimeException) {
            Toast.makeText(this, R.string.message_datetime_exception, Toast.LENGTH_LONG).show()
        }
    }

    fun clearButtonClicked()
    {
        clearEditTexts()
        initBirthDateTexts()
        mBinding.accept = false
        mBinding.passwordInputType = INPUT_TYPE_TEXT_PASSWORD_HIDE
        mBinding.showPasswordButtonText = resources.getString(R.string.button_show_password_text)
        mBinding.show = true
        mBinding.result = ""
        mBinding.allowShowPasswordChecked = false
        mBinding.mainActivityEditTextName.requestFocus()
    }

    fun closeButtonClicked()
    {
        promptDecision(this, R.string.confirm_close_alert_dialog_title, R.string.message_confirm_close,
            R.string.yes_button_text, R.string.no_button_text,
            {_, _ -> positiveButtonClickedCallback()}) {_, _ -> negativeButtonClickedCallback()}
    }
}