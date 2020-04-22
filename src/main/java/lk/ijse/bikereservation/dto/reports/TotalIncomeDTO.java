package lk.ijse.bikereservation.dto.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalIncomeDTO {
    private double totalAmount;
    private String monthName;
}
