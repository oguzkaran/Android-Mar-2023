package org.csystem.android.app.payment.data.service.dto

import java.io.Serializable

data class PaymentSaveDTO(var userName: String = "", var price: Double = 0.0,
                          var quantity: Double = 0.0, var desc: String = "") : Serializable