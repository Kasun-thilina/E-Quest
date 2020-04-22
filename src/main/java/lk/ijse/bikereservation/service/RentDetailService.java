package lk.ijse.bikereservation.service;

import lk.ijse.bikereservation.dto.CommonRentDTO;
import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.dto.reports.ReservationDetailSummaryDTO;
import lk.ijse.bikereservation.dto.reports.ReservedBikeDTO;
import lk.ijse.bikereservation.dto.reports.TotalIncomeDTO;

import java.util.List;

/**
 * @author Chalodya
 * @since 2019/09
 **/
public interface RentDetailService {

    public CommonRentDTO updateReservation(int rentId, CommonRentDTO commonRentDTO);

    public List<ReservationDetailSummaryDTO> getAllReservations();

    public RentDetailDTO searchReservationByRentId(int rentId);

    public List<ReservationDetailSummaryDTO> searchReservationByGuestId(int guestId);

    public List<TotalIncomeDTO> getTotalIncome();

    public List<ReservedBikeDTO> getUnReservedBikes(String date1,String date2);
}
