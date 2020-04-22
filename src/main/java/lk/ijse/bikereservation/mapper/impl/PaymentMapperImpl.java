package lk.ijse.bikereservation.mapper.impl;

import lk.ijse.bikereservation.dto.PaymentDTO;
import lk.ijse.bikereservation.entity.Payment;
import lk.ijse.bikereservation.mapper.PaymentMapper;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public PaymentDTO convertToPaymentDTO(Payment payment) {
        if (payment == null){
            return null;
        }else {
            return new PaymentDTO(
                    payment.getPaymentId(),
                    payment.getCardHoldersName(),
                    payment.getBankName(),
                    payment.getCardNumber(),
                    payment.getTotalAmount()
            );
        }
    }

    @Override
    public Payment convertToPayment(PaymentDTO paymentDTO) {
        if (paymentDTO == null){
            return null;
        }else {
            return new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getCardHoldersName(),
                    paymentDTO.getBankName(),
                    paymentDTO.getCardNumber(),
                    paymentDTO.getTotalAmount()
            );
        }
    }
}
