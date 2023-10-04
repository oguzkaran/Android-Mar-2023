package org.csystem.android.app.payment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karandev.util.data.service.DataServiceException
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.data.service.PaymentApplicationDataService
import org.csystem.android.app.data.service.dto.UserSaveDTO
import org.csystem.android.app.payment.databinding.ActivityRegisterBinding
import org.csystem.android.app.payment.viewmodel.RegisterActivityListenerViewModel
import java.time.LocalDate
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding

    @Inject
    lateinit var dataService: PaymentApplicationDataService

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        mBinding.viewModel = RegisterActivityListenerViewModel(this)
        mBinding.user = UserSaveDTO()
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

    fun registerButtonClicked()
    {
        try {
            val user = mBinding.user!!

            if (user.birthDate.equals(LocalDate.now())) {
                Toast.makeText(this, "Invalid data format", Toast.LENGTH_LONG).show()
                return
            }

            if (dataService.saveUser(user))
                Toast.makeText(this, "${user.username} successfully registered", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "${user.username} can not be registered", Toast.LENGTH_LONG).show()
        }
        catch (ex: DataServiceException) {
            Toast.makeText(this, "Data problem:${ex.message}", Toast.LENGTH_LONG).show()
        }
        catch (ignore: Throwable) {
            Toast.makeText(this, "Problem occurred. Try again later", Toast.LENGTH_LONG).show()
        }
    }
}