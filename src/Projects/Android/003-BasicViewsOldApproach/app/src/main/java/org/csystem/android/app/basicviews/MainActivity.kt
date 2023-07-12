package org.csystem.android.app.basicviews

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    private fun registerButtonClickedCallback()
    {
       try {
           //...
           val name = mEditTextName.text.toString()
           val email = mEditTextEmail.text.toString()
           val birthDate = LocalDate.of(mEditTextYear.text.toString().toInt(),
               mEditTextMonth.text.toString().toInt(), mEditTextDay.text.toString().toInt())
           val registerInfo = RegisterInfo(name, email, birthDate)

           Toast.makeText(this, registerInfo.toString(), Toast.LENGTH_LONG).show()
       }
       catch (ignore: NumberFormatException) {
            Toast.makeText(this, R.string.message_number_format_exception, Toast.LENGTH_LONG).show()
       }
       catch (ignore: DateTimeException) {
           Toast.makeText(this, R.string.message_datetime_exception, Toast.LENGTH_LONG).show()
       }
    }

    private fun initRegisterButton()
    {
        mButtonRegister = findViewById<Button>(R.id.mainActivityButtonRegister)
            .apply { setOnClickListener { registerButtonClickedCallback() }}
    }

    private fun initCloseButton()
    {
        findViewById<Button>(R.id.mainActivityButtonClose).apply { setOnClickListener { finish() }}
    }

    private fun initAcceptCheckBox()
    {
        findViewById<CheckBox>(R.id.mainActivityCheckboxAcceptConditions)
            .apply { setOnCheckedChangeListener{_, checked -> mButtonRegister.isEnabled = checked}}
    }

    private fun initEditTexts()
    {
        mEditTextName = findViewById(R.id.mainActivityEditTextName)
        mEditTextEmail = findViewById(R.id.mainActivityEditTextEmail)
        mEditTextDay = findViewById(R.id.mainActivityEditTextDay)
        mEditTextMonth = findViewById(R.id.mainActivityEditTextMonth)
        mEditTextYear = findViewById(R.id.mainActivityEditTextYear)
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