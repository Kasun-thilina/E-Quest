package lk.ijse.bikereservation.service;

import lk.ijse.bikereservation.dto.BikeDTO;
import lk.ijse.bikereservation.entity.Bike;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * this is used for handle bike service layer
 * @author Chalodya
 * @since 2019/08
 **/
public interface BikeService {

    public BikeDTO saveBike(BikeDTO bikeDTO);

    public Bike updateBike(int bikeId,BikeDTO bikeDTO);

    public Bike updateBikePrice(int bikeId, BikeDTO bikeDTO);

    public ResponseEntity deleteBike(int bikeId);

    public BikeDTO searchBikeById(int bikeId);

    public List<BikeDTO> getAllBikes();

    public List<BikeDTO> findBikeByStatus();
}
