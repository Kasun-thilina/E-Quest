package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author Chalodya
 * @since 2019/08
 **/
@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query(value = "SELECT * FROM guest u WHERE u.userName = :user_name",
            nativeQuery =true)
    Guest findByUserName(
            @Param("user_name") String userName);


}
