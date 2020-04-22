package lk.ijse.bikereservation.dto.reports;

import lombok.*;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservedBikeDTO {
    private int bikeId;
    private String bikeBrandName;
    private String bikeName;
    private String bikeNumber;
    private double bikePrice;
    private String bikeType;
    private String status;
}
