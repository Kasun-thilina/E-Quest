package lk.ijse.bikereservation.mapper.impl;

import lk.ijse.bikereservation.dto.GuestDTO;
import lk.ijse.bikereservation.entity.Guest;
import lk.ijse.bikereservation.mapper.GuestMapper;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public class GuestMapperImpl implements GuestMapper {
    @Override
    public GuestDTO convertToGuestDTO(Guest guest) {
        if (guest == null){
            return null;
        }else {
            return new GuestDTO(
                    guest.getGuestId(),
                    guest.getGuestName(),
                    guest.getPassportNumber(),
                    guest.getCountry(),
                    guest.getUserType(),
                    guest.getMobileNumber(),
                    guest.getEmail(),
                    guest.getUserName(),
                    guest.getPassword()
            );
        }
    }

    @Override
    public Guest convertToGuest(GuestDTO guestDTO) {
        if (guestDTO == null){
            return null;
        }else {
            return new Guest(
                    guestDTO.getGuestId(),
                    guestDTO.getGuestName(),
                    guestDTO.getPassportNumber(),
                    guestDTO.getCountry(),
                    guestDTO.getUserType(),
                    guestDTO.getMobileNumber(),
                    guestDTO.getEmail(),
                    guestDTO.getUserName(),
                    guestDTO.getPassword()
            );
        }
    }
}
