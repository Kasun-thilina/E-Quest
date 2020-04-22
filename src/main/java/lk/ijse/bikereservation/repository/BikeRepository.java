package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Chalodya
 * @since 2019/08
 **/
public interface BikeRepository extends JpaRepository<Bike, Integer> {

    @Query(value = "SELECT * FROM bike u WHERE u.bikeStatus = 'Available'",
            nativeQuery =true)
    List<Bike> findBikeByStatus();

}
