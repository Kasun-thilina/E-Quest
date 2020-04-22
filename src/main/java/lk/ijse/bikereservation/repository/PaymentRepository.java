package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
