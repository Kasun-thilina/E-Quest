package lk.ijse.bikereservation.mapper;

import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.entity.RentDetail;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface RentDetailMapper {

    RentDetailDTO convertToRentDetailDTO(RentDetail rentDetail);

    RentDetail convertToRentDetail(RentDetailDTO rentDetailDTO);
}
