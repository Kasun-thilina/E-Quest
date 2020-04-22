package lk.ijse.bikereservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentDTO {
    private int paymentId;
    private String cardHoldersName;
    private String bankName;
    private int cardNumber;
    private double totalAmount;

    public PaymentDTO(int paymentId, String cardHoldersName, String bankName, int cardNumber, double totalAmount) {
        this.paymentId = paymentId;
        this.cardHoldersName = cardHoldersName;
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.totalAmount = totalAmount;
    }
}
