package lk.ijse.bikereservation.mapper;

import lk.ijse.bikereservation.dto.PaymentDTO;
import lk.ijse.bikereservation.entity.Payment;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface PaymentMapper {

    PaymentDTO convertToPaymentDTO(Payment payment);

    Payment convertToPayment(PaymentDTO paymentDTO);

}
