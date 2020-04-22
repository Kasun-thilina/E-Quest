package lk.ijse.bikereservation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Entity
@Table(name = "Rent_Detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
