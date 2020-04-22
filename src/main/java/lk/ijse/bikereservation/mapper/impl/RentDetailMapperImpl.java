package lk.ijse.bikereservation.mapper.impl;

import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.entity.RentDetail;
import lk.ijse.bikereservation.mapper.RentDetailMapper;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public class RentDetailMapperImpl implements RentDetailMapper {
    @Override
    public RentDetailDTO convertToRentDetailDTO(RentDetail rentDetail) {
        if (rentDetail == null){
            return null;
        }else {
            return new RentDetailDTO(
                    rentDetail.getRentDetailId(),
                    rentDetail.getBikeId(),
                    rentDetail.getRentId(),
                    rentDetail.getRentDate(),
                    rentDetail.getHandOverDate(),
                    rentDetail.getLocation(),
                    rentDetail.getStatus()
            );
        }
    }

    @Override
    public RentDetail convertToRentDetail(RentDetailDTO rentDetailDTO) {
        if (rentDetailDTO == null){
            return null;
        }else {
            return new RentDetail(
                    rentDetailDTO.getRentDetailId(),
                    rentDetailDTO.getBikeId(),
                    rentDetailDTO.getRentId(),
                    rentDetailDTO.getRentDate(),
                    rentDetailDTO.getHandOverDate(),
                    rentDetailDTO.getLocation(),
                    rentDetailDTO.getStatus()
            );
        }
    }
}
