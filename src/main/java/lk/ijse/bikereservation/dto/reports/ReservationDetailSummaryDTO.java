package lk.ijse.bikereservation.dto.reports;

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
public class ReservationDetailSummaryDTO {
    private int bikeId;
    private int rentId;
    private String rentDate;
    private String handOverDate;
    private String location;
    private String status;
    private String userName;
    private double totalAmount;
    private String bikeName;
    private String bikeNumber;
    private String guestName;

    public ReservationDetailSummaryDTO(int bikeId,String bikeNumber,int rentId, String rentDate, String handOverDate, String location, String status, String userName, double totalAmount) {
        this.bikeId = bikeId;
        this.bikeNumber = bikeNumber;
        this.rentId = rentId;
        this.rentDate = rentDate;
        this.handOverDate = handOverDate;
        this.location = location;
        this.status = status;
        this.userName = userName;
        this.totalAmount = totalAmount;
    }

    public ReservationDetailSummaryDTO(int bikeId,int rentId, String rentDate, String handOverDate, String location, String status, double totalAmount, String bikeName, String bikeNumber, String guestName) {
        this.bikeId = bikeId;
        this.rentId = rentId;
        this.rentDate = rentDate;
        this.handOverDate = handOverDate;
        this.location = location;
        this.status = status;
        this.totalAmount = totalAmount;
        this.bikeName = bikeName;
        this.bikeNumber = bikeNumber;
        this.guestName = guestName;
    }
}
