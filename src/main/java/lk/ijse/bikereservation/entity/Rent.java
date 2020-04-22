package lk.ijse.bikereservation.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Entity
@Table(name = "Rent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;
    private int guestId;
    private int paymentId;

}
