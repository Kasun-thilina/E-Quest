package lk.ijse.bikereservation.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
     * this class is for bikeDTO
 * @author Chalodya
 * @since 2019/08
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BikeDTO {
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

}
