package lk.ijse.bikereservation.controller;

import lk.ijse.bikereservation.dto.BikeDTO;
import lk.ijse.bikereservation.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @PostMapping("/saveBike")
    public ResponseEntity addBikeDetails(@RequestBody BikeDTO bikeDTO){
        return new ResponseEntity(bikeService.saveBike(bikeDTO), HttpStatus.OK);
    }

    @GetMapping("/getAllBikes")
    public ResponseEntity getAllBikes(){
        return new ResponseEntity(bikeService.getAllBikes(),HttpStatus.OK);
    }

    @PutMapping("/updateBike/{bikeId}")
    public ResponseEntity updateBikeDetails(@PathVariable(value = "bikeId")int bikeId,@RequestBody BikeDTO bikeDTO){
        return new ResponseEntity(bikeService.updateBike(bikeId,bikeDTO),HttpStatus.OK);
    }

    @PutMapping("/updateBikePrice/{bikeId}")
    public ResponseEntity updateBikePrice(@PathVariable(value = "bikeId")int bikeId,@RequestBody BikeDTO bikeDTO){
        return new ResponseEntity(bikeService.updateBikePrice(bikeId,bikeDTO),HttpStatus.OK);
    }

    @GetMapping("/findBike/{bikeId}")
    public ResponseEntity getBikeDetailById(@PathVariable("bikeId")int bikeId){
        return new ResponseEntity(bikeService.searchBikeById(bikeId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteBike/{bikeId}")
    public ResponseEntity deleteBike(@PathVariable("bikeId")int bikeId){
        return new ResponseEntity(bikeService.deleteBike(bikeId),HttpStatus.OK);

    }

    @GetMapping("/getBikeByStatus")
    public ResponseEntity findBikeByStatus(){
        return new ResponseEntity(bikeService.findBikeByStatus(),HttpStatus.OK);
    }
}
