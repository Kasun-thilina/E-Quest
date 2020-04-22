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
public class RentDetailDTO {
    private int rentDetailId;
    private int bikeId;
    private int rentId;
//    @Temporal(TemporalType.DATE)
    private String rentDate;
//    @Temporal(TemporalType.DATE)
    private String handOverDate;
    private String location;
    private String status;
}
