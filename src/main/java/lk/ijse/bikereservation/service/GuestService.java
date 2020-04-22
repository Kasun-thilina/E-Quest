package lk.ijse.bikereservation.service;

import lk.ijse.bikereservation.dto.GuestDTO;
import lk.ijse.bikereservation.entity.Guest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * this interface is for guestService
 * @author Chalodya
 * @since 2019/08
 **/
public interface GuestService {

    public GuestDTO saveGuest(GuestDTO guestDTO);

    public GuestDTO updateGuestDetails(int guestId,GuestDTO guestDTO);

    public ResponseEntity removeGuest(int guestId);

    public GuestDTO searchGuestsDetails(int guestId);

    public List<GuestDTO> getAllGuestDetails();

    public boolean isUserExists(GuestDTO guestDTO);

    public Guest findOne(String username);

    public GuestDTO searchGuestByUserName(String userName);






}
