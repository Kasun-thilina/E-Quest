package lk.ijse.bikereservation.mapper;

import lk.ijse.bikereservation.dto.RentDTO;
import lk.ijse.bikereservation.entity.Rent;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface RentMapper {

    RentDTO convertToRentDTO(Rent rent);

    Rent convertToRent(RentDTO rentDTO);

}
