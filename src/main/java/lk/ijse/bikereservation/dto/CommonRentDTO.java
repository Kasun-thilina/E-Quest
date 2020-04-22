package lk.ijse.bikereservation.dto;

import lombok.*;

import java.util.List;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommonRentDTO {
    private int rentId;
    private int guestId;

    private int paymentId;
    private String cardHoldersName;
    private String bankName;
    private int cardNumber;
    private double totalAmount;

    private List<RentDetailDTO> rentDetailDTOS;

    private String status;
    private String bikeStatus;
    private int bikeId;

    public CommonRentDTO(int rentId, int guestId, int paymentId, String cardHoldersName, String bankName, int cardNumber, double totalAmount, List<RentDetailDTO> rentDetailDTOS) {
        this.rentId = rentId;
        this.guestId = guestId;
        this.paymentId = paymentId;
        this.cardHoldersName = cardHoldersName;
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.totalAmount = totalAmount;
        this.rentDetailDTOS = rentDetailDTOS;
    }

    public CommonRentDTO(int rentId, int bikeId, String status, String bikeStatus) {
        this.rentId = rentId;
        this.bikeId = bikeId;
        this.status = status;
        this.bikeStatus = bikeStatus;

    }
}
