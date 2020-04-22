package lk.ijse.bikereservation.mapper.impl;

import lk.ijse.bikereservation.dto.RentDTO;
import lk.ijse.bikereservation.entity.Rent;
import lk.ijse.bikereservation.mapper.RentMapper;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public class RentMapperImpl implements RentMapper {
    @Override
    public RentDTO convertToRentDTO(Rent rent) {
        if (rent == null){
            return null;
        }else {
            return new RentDTO(
                    rent.getRentId(),
                    rent.getGuestId(),
                    rent.getPaymentId()

            );
        }
    }

    @Override
    public Rent convertToRent(RentDTO rentDTO) {
        if (rentDTO == null){
            return null;
        }else {
            return new Rent(
                    rentDTO.getRentId(),
                    rentDTO.getGuestId(),
                    rentDTO.getPaymentId()
            );
        }
    }
}
