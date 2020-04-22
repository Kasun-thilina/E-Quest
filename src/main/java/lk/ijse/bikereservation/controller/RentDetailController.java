package lk.ijse.bikereservation.controller;

import lk.ijse.bikereservation.dto.BikeDTO;
import lk.ijse.bikereservation.dto.CommonRentDTO;
import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.service.RentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@CrossOrigin
@RequestMapping(value = "rentDetails")
@RestController
public class RentDetailController {

    @Autowired
    RentDetailService rentDetailService;

    @PutMapping("/updateReservationStatus/{rentId}")
    public ResponseEntity updateReservation(@PathVariable(value = "rentId")int rentId, @RequestBody CommonRentDTO commonRentDTO){
        return new ResponseEntity(rentDetailService.updateReservation(rentId,commonRentDTO), HttpStatus.OK);
    }

    @GetMapping("/reservationSummary")
    public ResponseEntity getReservationSummary(){
        return new ResponseEntity(rentDetailService.getAllReservations(),HttpStatus.OK);
    }

    @GetMapping("/searchReservation/{rentId}")
    public ResponseEntity searchReservationByRentId(@PathVariable(value = "rentId")int rentId){
        return new ResponseEntity(rentDetailService.searchReservationByRentId(rentId),HttpStatus.OK);
    }

    @GetMapping("/searchReservationByGuestId/{guestId}")
    public ResponseEntity searchReservationByGuestId(@PathVariable(value = "guestId")int guestId){
        return new ResponseEntity(rentDetailService.searchReservationByGuestId(guestId),HttpStatus.OK);
    }

    @GetMapping("/getTotalIncome")
    public ResponseEntity getTotalIncome(){
        return new ResponseEntity(rentDetailService.getTotalIncome(),HttpStatus.OK);
    }

    @GetMapping("/getReservedBike/{date1}/{date2}")
    public ResponseEntity getReservedBikes(@PathVariable(value = "date1")String date1,@PathVariable(value = "date2")String date2){
        return new ResponseEntity(rentDetailService.getUnReservedBikes(date1,date2),HttpStatus.OK);
    }


}
