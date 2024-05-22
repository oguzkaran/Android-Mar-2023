package org.csystem.android.app.payment.data.service.mapper

import org.csystem.android.app.payment.data.service.dto.PaymentSaveDTO
import org.csystem.android.app.payment.repository.entity.Payment
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(implementationName = "PaymentMapperImpl")
interface IPaymentMapper {
    @Mapping(source = "price", target = "unitPrice")
    @Mapping(source = "desc", target = "description")
    fun toPayment(paymentSaveDTO: PaymentSaveDTO): Payment
}