package org.csystem.android.app.basicviews

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.csystem.android.app.basicviews.global.alert.promptDecision
import org.csystem.android.app.basicviews.global.alert.promptNotConfirmedDialog
import org.csystem.android.app.basicviews.viewmodel.RegisterInfo
import java.time.DateTimeException
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var mButtonRegister: Button
    private lateinit var mEditTextName: EditText
    private lateinit var mEditTextEmail: EditText
    private lateinit var mEditTextDay: EditText
    private lateinit var mEditTextMonth: EditText
    private lateinit var mEditTextYear: EditText
    private lateinit var mEditTextUserName: EditText
    private lateinit var mEditTextPassword: EditText
    private lateinit var mEditTextConfirmPassword: EditText

    private fun neutralButtonClickedCallback()
    {
        mEditTextConfirmPassword.setText("")
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
        val password = mEditTextPassword.text.toString()
        if (!confirm(password, mEditTextConfirmPassword.text.toString()))
            return null

        val name = mEditTextName.text.toString()
        val email = mEditTextEmail.text.toString()
        val birthDate = LocalDate.of(mEditTextYear.text.toString().toInt(),
            mEditTextMonth.text.toString().toInt(), mEditTextDay.text.toString().toInt())
        val userName = mEditTextUserName.text.toString()

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
        mButtonRegister = findViewById<Button>(R.id.mainActivityButtonRegister)
            .apply { setOnClickListener { registerButtonClickedCallback() }}
    }

    private fun initCloseButton()
    {
        findViewById<Button>(R.id.mainActivityButtonClose).apply { setOnClickListener { closeButtonClickedCallback() }}
    }

    private fun initAcceptCheckBox()
    {
        findViewById<CheckBox>(R.id.mainActivityCheckboxAcceptConditions)
            .apply { setOnCheckedChangeListener{_, checked -> mButtonRegister.isEnabled = checked}}
    }

    private fun initEditTexts()
    {
        //Getting references via old approach
        mEditTextName = findViewById(R.id.mainActivityEditTextName)
        mEditTextEmail = findViewById(R.id.mainActivityEditTextEmail)
        mEditTextDay = findViewById(R.id.mainActivityEditTextDay)
        mEditTextMonth = findViewById(R.id.mainActivityEditTextMonth)
        mEditTextYear = findViewById(R.id.mainActivityEditTextYear)
        mEditTextUserName = findViewById(R.id.mainActivityEditTextUserName)
        mEditTextPassword = findViewById(R.id.mainActivityEditTextPassword)
        mEditTextConfirmPassword = findViewById(R.id.mainActivityEditTextConfirmPassword)
    }

    private fun initViews()
    {
        initEditTexts()
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
        setContentView(R.layout.activity_main)
        initialize()
    }
}