package lk.ijse.bikereservation.controller;

import lk.ijse.bikereservation.dto.CommonRentDTO;
import lk.ijse.bikereservation.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/rent")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/saveReservation")
    public ResponseEntity makeReservation(@RequestBody CommonRentDTO commonRentDTO){
        return new ResponseEntity(rentService.addRent(commonRentDTO), HttpStatus.OK);
    }

}
