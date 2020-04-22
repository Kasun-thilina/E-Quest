package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.RentDetail;
import lk.ijse.bikereservation.entity.reports.ReservationDetailSummary;
import lk.ijse.bikereservation.entity.reports.ReservedBike;
import lk.ijse.bikereservation.entity.reports.TotalIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * this is for rentDetailRepository
 * @author Chalodya
 * @since 2019/08
 **/
public interface RentDetailRepository extends JpaRepository<RentDetail,Integer> {
    @Query(value = "SELECT new lk.ijse.bikereservation.entity.reports.ReservationDetailSummary(b.bikeId,b.bikeNumber,r.rentId,r.rentDate,r.handOverDate,r.location,r.status,g.userName,p.totalAmount) FROM RentDetail r, Guest g , Rent t , Payment p,Bike b WHERE " +
            "g.guestId = t.guestId  AND t.rentId = r.rentId GROUP BY t.rentId",
            nativeQuery = false)
    List<ReservationDetailSummary> getReservationSummary();

    @Query(value = "SELECT new lk.ijse.bikereservation.entity.reports.ReservationDetailSummary(b.bikeId,r.rentId,d.rentDate,d.handOverDate," +
            "d.location,d.status,p.totalAmount," +
            "b.bikeName,b.bikeNumber,g.guestName) FROM Guest g, Rent r , RentDetail d, Bike b , Payment p WHERE g.guestId = r.guestId AND " +
            "r.rentId = d.rentId AND r.paymentId = p.paymentId AND g.guestId=:guestId GROUP BY d.rentDetailId",
            nativeQuery = false)
    List<ReservationDetailSummary> getReservationByGuestId(@Param(value = "guestId")int guestId);

    @Query(value = "SELECT new lk.ijse.bikereservation.entity.reports.TotalIncome(SUM(p.totalAmount), MONTHNAME(d.rentDate)) FROM Rent r , Payment p,RentDetail d WHERE " +
            "r.paymentId = p.paymentId AND r.rentId = d.rentId GROUP BY MONTH(d.rentDate)",
            nativeQuery = false)
    List<TotalIncome> getTotalIncome();

    @Query(value = "SELECT new lk.ijse.bikereservation.entity.reports.ReservedBike(b.bikeId,b.bikeBrandName,b.bikeName,b.bikeNumber,b.bikePrice,b.bikeType,b.bikeStatus) " +
            "FROM Bike b LEFT JOIN RentDetail d ON d.bikeId = b.bikeId WHERE d.handOverDate NOT BETWEEN :date1 AND :date2",
            nativeQuery = false)
    List<ReservedBike> getUnReservedBikes(@Param("date1")String date1,@Param(value = "date2")String date2);

}



