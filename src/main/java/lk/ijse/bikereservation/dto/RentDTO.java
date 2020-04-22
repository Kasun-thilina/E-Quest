package lk.ijse.bikereservation.dto;

import lombok.*;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentDTO {
    private int rentId;
    private int guestId;
    private int paymentId;
}
