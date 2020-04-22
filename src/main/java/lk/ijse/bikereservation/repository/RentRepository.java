package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * this is for rentRepository
 * @author Chalodya
 * @since 2019/08
 **/
public interface RentRepository extends JpaRepository<Rent,Integer> {
}
