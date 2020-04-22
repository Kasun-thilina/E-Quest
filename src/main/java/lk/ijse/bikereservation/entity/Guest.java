package lk.ijse.bikereservation.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * this class is for guest entity
 * @author Chalodya
 * @since 2019/08
 **/
@Entity
@Table(name = "Guest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "Guest Id Is Compulsory")
//    @Min(0)
//    @Max(200000)
    private int guestId;

//    @NotNull(message = "Guest Name Is Compulsory")
//    @Size(min=2,max = 150, message = "Guest Name Should be at least 2 characters & less than 150")
    private String guestName;

    private String passportNumber;

//    @NotNull(message = "Country Name Is Compulsory")
//    @Size(min=2,max = 150, message = "Country Name Should be at least 2 characters & less than 150")
    private String country;

//    @NotNull(message = "user type is compulsory")
//    @Size(min = 5,max = 100,message = "user type should be less than 100 and more than 5 characters")
    private String userType;

//    @NotNull(message = "Mobile Number Is Compulsory")
    private String mobileNumber;

//    @NotNull(message = "Email Is Compulsory")
    @Size(min = 5,max = 500,message = "Email Should be at least 5 characters & less than 500")
    private String email;

//    @NotNull(message = "User Name Is Compulsory")
//    @Size(min = 5,max = 500,message = "UserName Should be at least 5 characters & less than 100")
    private String userName;

//    @NotNull(message = "Password Is Compulsory")
//    @Size(min = 8,max = 500,message = "Password Should be at least 8 characters & less than 50")
    private String password;


//    public Guest(int guestId,@NotNull(message = "Guest Name Is Compulsory") @Size(min = 2, max = 150, message = "Guest Name Should be at least 2 characters & less than 150") String guestName, String passportNumber, @NotNull(message = "Country Name Is Compulsory") @Size(min = 2, max = 150, message = "Country Name Should be at least 2 characters & less than 150") String country, @NotNull(message = "user type is compulsory") @Size(min = 5, max = 100, message = "user type should be less than 100 and more than 5 characters") String userType, @NotNull(message = "Mobile Number Is Compulsory") String mobileNumber, @NotNull(message = "Email Is Compulsory") @Size(min = 5, max = 500, message = "Email Should be at least 5 characters & less than 500") String email, @NotNull(message = "User Name Is Compulsory") @Size(min = 5, max = 500, message = "UserName Should be at least 5 characters & less than 100") String userName, @NotNull(message = "Password Is Compulsory") @Size(min = 8, max = 500, message = "Password Should be at least 8 characters & less than 50") String password) {
//        this.guestId = guestId;
//        this.guestName = guestName;
//        this.passportNumber = passportNumber;
//        this.country = country;
//        this.userType = userType;
//        this.mobileNumber = mobileNumber;
//        this.email = email;
//        this.userName = userName;
//        this.password = password;
//    }




}
