package lk.ijse.bikereservation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private String cardHoldersName;
    private String bankName;
    private int cardNumber;
    private double totalAmount;


    public Payment(String cardHoldersName, String bankName, int cardNumber, double totalAmount) {
        this.cardHoldersName = cardHoldersName;
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.totalAmount = totalAmount;
    }
}
