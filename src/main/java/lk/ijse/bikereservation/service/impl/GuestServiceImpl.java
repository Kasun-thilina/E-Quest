package lk.ijse.bikereservation.service.impl;

import lk.ijse.bikereservation.exception.RecordNotFoundException;
import lk.ijse.bikereservation.mapper.GuestMapper;
import lk.ijse.bikereservation.mapper.impl.GuestMapperImpl;
import lk.ijse.bikereservation.repository.GuestRepository;
import lk.ijse.bikereservation.dto.GuestDTO;
import lk.ijse.bikereservation.entity.Guest;
import lk.ijse.bikereservation.repository.RoleRepository;
import lk.ijse.bikereservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this class is for guestServiceImpl
 * @author Chalodya
 * @since 2019/08
 **/
@Service(value = "userService")
public class GuestServiceImpl implements GuestService , UserDetailsService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    private static final String ACTION_1 = "Guest Not Found";

    private GuestMapper guestMapper = new GuestMapperImpl();


    @Override
    public GuestDTO saveGuest(GuestDTO guestDTO) {
        String encryptedPassword = passwordEncoder.encode(guestDTO.getPassword());
        guestDTO.setPassword(encryptedPassword);
        GuestDTO guest = new GuestDTO(guestDTO.getGuestId(),guestDTO.getGuestName(),guestDTO.getPassportNumber(),
                guestDTO.getCountry(),guestDTO.getUserType(),guestDTO.getMobileNumber(),guestDTO.getEmail(),
                guestDTO.getUserName(),guestDTO.getPassword());
        guestRepository.save(guestMapper.convertToGuest(guest));
        return guestDTO;
    }

    @Override
    public GuestDTO updateGuestDetails(int guestId, GuestDTO guestDTO) {
        Guest guest = guestRepository.findById(guestId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        if (guest != null){
            guest.setGuestId(guestDTO.getGuestId());
            guest.setGuestName(guestDTO.getGuestName());
            guest.setPassportNumber(guestDTO.getPassportNumber());
            guest.setMobileNumber(guestDTO.getMobileNumber());
            guest.setEmail(guestDTO.getEmail());
            guestDTO.setUserName(guestDTO.getUserName());
            guestDTO.setPassword(guestDTO.getPassword());
            guestRepository.save(guest);
        }
        return guestDTO;
    }

    @Override
    public ResponseEntity removeGuest(int guestId) {
        Guest guest = guestRepository.findById(guestId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        guestRepository.delete(guest);
        return ResponseEntity.ok().build();

    }

    @Override
    public GuestDTO searchGuestsDetails(int guestId) {
        Guest guest = null;
        guest =guestRepository.findById(guestId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        if (guest != null){
            return new GuestDTO(guest.getGuestId(),guest.getGuestName(),
                    guest.getPassportNumber(),guest.getCountry(),guest.getUserType(),
                    guest.getMobileNumber(),guest.getEmail(),guest.getUserName(),guest.getPassword());
        }
        return null;
    }

    @Override
    public List<GuestDTO> getAllGuestDetails() {
        List<Guest> guestList = guestRepository.findAll();
        List<GuestDTO> guestDTOS = new ArrayList<>();
        for (Guest guest : guestList){
                guestDTOS.add(new GuestDTO(guest.getGuestId(),
                        guest.getGuestName(),guest.getPassportNumber(),
                        guest.getCountry(),guest.getUserType(),guest.getMobileNumber(),
                        guest.getEmail(),guest.getUserName(),guest.getPassword()));
        }
        return guestDTOS;
    }

    @Override
    public boolean isUserExists(GuestDTO guestDTO) {
        boolean userExistes = false;
        Guest guest = guestRepository.findByUserName(guestDTO.getUserName());
        if (guest != null){
            userExistes = true;
        }
        return userExistes;

    }

    @Override
    public Guest findOne(String username) {
        return guestRepository.findByUserName(username);

    }

    @Override
    public GuestDTO searchGuestByUserName(String userName) {
        Guest guest = null;
        guest =guestRepository.findByUserName(userName);
        if (guest != null){
            return new GuestDTO(guest.getGuestId(),guest.getGuestName(),
                    guest.getPassportNumber(),guest.getCountry(),guest.getUserType(),
                    guest.getMobileNumber(),guest.getEmail(),guest.getUserName(),guest.getPassword());
        }
        return null;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Guest user = guestRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<Guest> findAll() {
        List<Guest> list = new ArrayList<>();
        guestRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


}
