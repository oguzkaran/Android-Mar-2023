package org.csystem.android.app.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.csystem.android.app.data.service.PaymentApplicationDataService
import org.csystem.android.app.data.service.dto.UserSaveDTO
import org.csystem.android.app.payment.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.Month
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    @Inject
    lateinit var dataService: PaymentApplicationDataService

    private fun initialize()
    {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initialize()

        saveUser()
    }

    fun saveUser()
    {
        val userSaveDTO = UserSaveDTO("Cem", "cem1234", "Cem", "?", LocalDate.of(2000, Month.JANUARY, 1), "?")

        dataService.saveUser(userSaveDTO)
    }
}