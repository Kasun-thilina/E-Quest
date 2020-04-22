package lk.ijse.bikereservation.service.impl;

import lk.ijse.bikereservation.entity.Bike;
import lk.ijse.bikereservation.exception.RecordNotFoundException;
import lk.ijse.bikereservation.repository.BikeRepository;
import lk.ijse.bikereservation.dto.BikeDTO;
import lk.ijse.bikereservation.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chalodya
 * @since 2019/08
 **/
@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    BikeRepository bikeRepository;

    private static final String ACTION_1 = "Bike Not Found";

    @Override
    public BikeDTO saveBike(BikeDTO bikeDTO) {
        bikeDTO.setBikeStatus("Available");
        Bike bike = new Bike(
                bikeDTO.getBikeId(),bikeDTO.getBikeNumber(),bikeDTO.getBikeName(),bikeDTO.getBikeType(),
                bikeDTO.getBikeBrandName(),bikeDTO.getBikePrice(),bikeDTO.getBikeStatus()
        );
        bikeRepository.save(bike);
        return bikeDTO;
    }

    @Override
    public Bike updateBike(int bikeId, BikeDTO bikeDTO) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        if (bike != null){
            bike.setBikeStatus(bikeDTO.getBikeStatus());
            bikeRepository.save(bike);
        }
        return bike;
    }

    @Override
    public Bike updateBikePrice(int bikeId, BikeDTO bikeDTO) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        if (bike != null) {
            bike.setBikePrice(bikeDTO.getBikePrice());
            bikeRepository.save(bike);
        }
        return bike;
    }

    @Override
    public ResponseEntity deleteBike(int bikeId) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        bikeRepository.delete(bike);
        return ResponseEntity.ok().build();
    }

    @Override
    public BikeDTO searchBikeById(int bikeId) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(()->new RecordNotFoundException(ACTION_1));
        if (bike != null){
            return new BikeDTO(bike.getBikeId(),bike.getBikeNumber(),bike.getBikeName(),bike.getBikeType(),bike.getBikeBrandName(),bike.getBikePrice(),bike.getBikeStatus());
        }
        return null;

    }

    @Override
    public List<BikeDTO> getAllBikes() {
        List<Bike> bikeList = bikeRepository.findAll();
        List<BikeDTO> bikeDTOS = new ArrayList<>();
        for (Bike bike : bikeList){
            bikeDTOS.add(new BikeDTO(bike.getBikeId(),bike.getBikeNumber(),bike.getBikeName(),bike.getBikeType(),bike.getBikeBrandName(),bike.getBikePrice(),bike.getBikeStatus()));
        }
        return bikeDTOS;
    }

    @Override
    public List<BikeDTO> findBikeByStatus() {
        List<Bike> bikeList = bikeRepository.findBikeByStatus();
        List<BikeDTO> bikeDTOS = new ArrayList<>();
        for (Bike bike : bikeList){
            bikeDTOS.add(new BikeDTO(bike.getBikeId(),bike.getBikeNumber(),bike.getBikeName(),bike.getBikeType(),bike.getBikeBrandName(),bike.getBikePrice(),bike.getBikeStatus()));
        }
        return bikeDTOS;
    }
}
