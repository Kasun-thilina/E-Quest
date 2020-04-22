package lk.ijse.bikereservation.entity.reports;

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
public class TotalIncome {
    private double totalAmount;
    private String monthName;
}
