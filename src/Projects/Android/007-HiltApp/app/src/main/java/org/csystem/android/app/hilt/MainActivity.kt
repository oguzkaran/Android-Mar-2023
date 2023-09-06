package org.csystem.android.app.hilt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.hilt.calculator.IIBinaryOperator
import org.csystem.android.app.hilt.calculator.di.module.annotation.IntAddOperationInterceptor
import org.csystem.android.app.hilt.databinding.ActivityMainBinding
import org.csystem.android.app.hilt.datetime.DateInfo
import org.csystem.android.app.hilt.datetime.DateTimeInfo
import org.csystem.android.app.hilt.datetime.TimeInfo
import org.csystem.android.app.hilt.viewmodel.MainActivityListenerViewModel
import org.csystem.android.app.hilt.viewmodel.OperationInfo
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var dateTimeInfo: DateTimeInfo

    @Inject
    lateinit var dateInfo: DateInfo

    @Inject
    lateinit var timeInfo: TimeInfo

    @Inject
    @IntAddOperationInterceptor
    lateinit var intBinaryOperator: IIBinaryOperator<Int>

    private fun showDateTime()
    {
        val sb = StringBuilder()

        sb.append("DateTime:").append(dateTimeInfo.toString()).append("\n")
            .append("Date:").append(dateInfo.toString()).append("\n")
            .append("Time:").append(timeInfo.toString())

        Toast.makeText(this, sb, Toast.LENGTH_LONG).show()
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.viewModel = MainActivityListenerViewModel(this)
        mBinding.operationInfo = OperationInfo()
    }

    private fun initialize()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onResume()
    {
        showDateTime()
        super.onResume()
    }

    fun calculateButtonClicked()
    {
        if (intBinaryOperator.isValid(mBinding.operationInfo!!.op))
            mBinding.resultText = intBinaryOperator.applyAsInt(mBinding.operationInfo!!.first, mBinding.operationInfo!!.second).toString()
        else
            mBinding.resultText = "Invalid operation"
    }
}