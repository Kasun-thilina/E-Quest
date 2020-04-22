package lk.ijse.bikereservation.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * this class is for store attributes of the bike entity
 * @author Chalodya
 * @since 2019/08
 **/
@Entity
@Table(name = "Bike")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "Bike Id Is Compulsory")
    @Min(0)
    @Max(200000)
    private int bikeId;

//    @NotNull(message = "Bike Number Is Compulsory")
    @Size(min=2,max = 20, message = "Bike Number Should be at least 2 characters & less than 20")
    private String bikeNumber;

//    @NotNull(message = "Bike Name Is Compulsory")
    @Size(min=2,max = 150, message = "Bike Name Should be at least 2 characters & less than 150")
    private String bikeName;

//    @NotNull(message = "Bike Type Is Compulsory")
    @Size(min=2,max = 150, message = "Bike Type Should be at least 2 characters & less than 150")
    private String bikeType;

//    @NotNull(message = "Bike Brand Name Is Compulsory")
    @Size(min=2,max = 150, message = "Bike Brand Name Should be at least 2 characters & less than 150")
    private String bikeBrandName;

    private double bikePrice;

    private String bikeStatus;

//    public Bike(@NotNull(message = "Bike Number Is Compulsory") @Size(min = 2, max = 20,
//            message = "Bike Number Should be at least 2 characters & less than 20") String bikeNumber,
//                @NotNull(message = "Bike Name Is Compulsory")
//                @Size(min = 2, max = 150, message = "Bike Name Should be at least 2 characters & less than 150")
//                        String bikeName, @NotNull(message = "Bike Type Is Compulsory")
//                @Size(min = 2, max = 150, message = "Bike Type Should be at least 2 characters & less than 150")
//                        String bikeType, @NotNull(message = "Bike Brand Name Is Compulsory")
//                @Size(min = 2, max = 150, message = "Bike Brand Name Should be at least 2 characters & less than 150")
//                        String bikeBrandName, double bikePrice, String status) {
//        this.bikeNumber = bikeNumber;
//        this.bikeName = bikeName;
//        this.bikeType = bikeType;
//        this.bikeBrandName = bikeBrandName;
//        this.bikePrice = bikePrice;
//        this.status = status;
//    }


    public Bike(@Size(min = 2, max = 20, message = "Bike Number Should be at least 2 characters & less than 20") String bikeNumber, @Size(min = 2, max = 150, message = "Bike Name Should be at least 2 characters & less than 150") String bikeName, @Size(min = 2, max = 150, message = "Bike Type Should be at least 2 characters & less than 150") String bikeType, @Size(min = 2, max = 150, message = "Bike Brand Name Should be at least 2 characters & less than 150") String bikeBrandName, double bikePrice, String bikeStatus) {
        this.bikeNumber = bikeNumber;
        this.bikeName = bikeName;
        this.bikeType = bikeType;
        this.bikeBrandName = bikeBrandName;
        this.bikePrice = bikePrice;
        this.bikeStatus = bikeStatus;
    }
}
