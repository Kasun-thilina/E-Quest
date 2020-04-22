package lk.ijse.bikereservation.mapper;

import lk.ijse.bikereservation.dto.GuestDTO;
import lk.ijse.bikereservation.entity.Guest;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface GuestMapper {

    GuestDTO convertToGuestDTO(Guest guest);

    Guest convertToGuest(GuestDTO guestDTO);

}
