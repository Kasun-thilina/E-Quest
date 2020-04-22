package lk.ijse.bikereservation.controller;

import lk.ijse.bikereservation.dto.GuestDTO;
import lk.ijse.bikereservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this class is for guest controller
 * @author Chalodya
 * @since 2019/08
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/guest")
public class GuestController {

    @Autowired
    GuestService guestService;

    @PostMapping("/saveGuest")
    public ResponseEntity saveGuestDetails(@RequestBody GuestDTO guestDTO){
        if (guestService.isUserExists(guestDTO)){
            return new ResponseEntity("User Already Exists",HttpStatus.BAD_REQUEST);
        }else {
            guestDTO.setUserType("guest");
            return new ResponseEntity(guestService.saveGuest(guestDTO), HttpStatus.OK);
        }
    }

    @GetMapping("/getAllGuests")
    public ResponseEntity getAllGuests(){
        return new ResponseEntity(guestService.getAllGuestDetails(),HttpStatus.OK);
    }

    @DeleteMapping("deleteGuest/{guestId}")
    public ResponseEntity deleteGuest(@PathVariable(value = "guestId")int guestId){
        return new ResponseEntity(guestService.removeGuest(guestId),HttpStatus.OK);
    }

    @GetMapping("/searchGuestByUserName/{userName}")
    public ResponseEntity searchGuestByUserName(@PathVariable(value = "userName")String userName){
        return new ResponseEntity(guestService.searchGuestByUserName(userName),HttpStatus.OK);

    }



}
