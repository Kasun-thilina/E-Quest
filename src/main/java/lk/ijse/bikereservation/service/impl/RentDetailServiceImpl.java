package lk.ijse.bikereservation.service.impl;

import lk.ijse.bikereservation.dto.BikeDTO;
import lk.ijse.bikereservation.dto.CommonRentDTO;
import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.dto.reports.ReservationDetailSummaryDTO;
import lk.ijse.bikereservation.dto.reports.ReservedBikeDTO;
import lk.ijse.bikereservation.dto.reports.TotalIncomeDTO;
import lk.ijse.bikereservation.entity.Bike;
import lk.ijse.bikereservation.entity.RentDetail;
import lk.ijse.bikereservation.entity.reports.ReservationDetailSummary;
import lk.ijse.bikereservation.entity.reports.ReservedBike;
import lk.ijse.bikereservation.entity.reports.TotalIncome;
import lk.ijse.bikereservation.exception.RecordNotFoundException;
import lk.ijse.bikereservation.mapper.RentDetailMapper;
import lk.ijse.bikereservation.mapper.impl.RentDetailMapperImpl;
import lk.ijse.bikereservation.repository.BikeRepository;
import lk.ijse.bikereservation.repository.RentDetailRepository;
import lk.ijse.bikereservation.service.RentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Service
public class RentDetailServiceImpl implements RentDetailService {

    @Autowired
    RentDetailRepository rentDetailRepository;
    @Autowired
    BikeRepository bikeRepository;

    private RentDetailMapper rentDetailMapper = new RentDetailMapperImpl();

    @Override
    public CommonRentDTO updateReservation(int rentId, CommonRentDTO commonRentDTO) {
        RentDetail rentDetail = rentDetailRepository.findById(rentId).orElseThrow(()->new RecordNotFoundException("Reservation Not Found"));

        if (rentDetail != null){
            rentDetail.setStatus(commonRentDTO.getStatus());
            rentDetailRepository.save(rentDetail);
        }
        Bike bike = bikeRepository.findById(commonRentDTO.getBikeId()).orElseThrow(()->
                new RecordNotFoundException("Bike Not Found"));
        System.out.println(bike);
        if (bike != null){
            bike.setBikeStatus(commonRentDTO.getBikeStatus());
            bikeRepository.save(bike);
        }
        return commonRentDTO;
    }

    @Override
    public List<ReservationDetailSummaryDTO> getAllReservations() {
        List<ReservationDetailSummary> reservationDetailSummaries = rentDetailRepository.getReservationSummary();
        List<ReservationDetailSummaryDTO> reservationDetailSummaryDTOS = new ArrayList<>();
        for (ReservationDetailSummary reservationDetailSummary : reservationDetailSummaries){
             reservationDetailSummaryDTOS.add(new ReservationDetailSummaryDTO(reservationDetailSummary.getBikeId(),reservationDetailSummary.getBikeNumber(),reservationDetailSummary.getRentId(),
                     reservationDetailSummary.getRentDate(),reservationDetailSummary.getHandOverDate(),
                     reservationDetailSummary.getLocation(),reservationDetailSummary.getStatus(),
                     reservationDetailSummary.getUserName(),reservationDetailSummary.getTotalAmount()));
        }
        return reservationDetailSummaryDTOS;
    }

    @Override
    public RentDetailDTO searchReservationByRentId(int rentId) {
        RentDetail rentDetail = rentDetailRepository.findById(rentId).orElseThrow(()->new RecordNotFoundException("Reservation Not Found"));
        if (rentDetail != null){
            return rentDetailMapper.convertToRentDetailDTO(rentDetail);
        }
        return null;
    }

    @Override
    public List<ReservationDetailSummaryDTO> searchReservationByGuestId(int guestId) {
        List<ReservationDetailSummary> detailSummaries = rentDetailRepository.getReservationByGuestId(guestId);
        List<ReservationDetailSummaryDTO> detailSummaryDTOS = new ArrayList<>();
        for (ReservationDetailSummary reservationDetailSummary : detailSummaries){
            detailSummaryDTOS.add(new ReservationDetailSummaryDTO(reservationDetailSummary.getBikeId(),reservationDetailSummary.getRentId(),
                    reservationDetailSummary.getRentDate(),reservationDetailSummary.getHandOverDate(),
                    reservationDetailSummary.getLocation(),reservationDetailSummary.getStatus(),
                    reservationDetailSummary.getTotalAmount(),reservationDetailSummary.getBikeName(),
                    reservationDetailSummary.getBikeNumber(),reservationDetailSummary.getGuestName()));
        }
        return detailSummaryDTOS;
    }

    @Override
    public List<TotalIncomeDTO> getTotalIncome() {
        List<TotalIncome> totalIncome1 = rentDetailRepository.getTotalIncome();
        List<TotalIncomeDTO> totalIncomeDTOS = new ArrayList<>();
        for (TotalIncome totalIncome : totalIncome1){
            totalIncomeDTOS.add(new TotalIncomeDTO(totalIncome.getTotalAmount(),totalIncome.getMonthName()));
        }
        return totalIncomeDTOS;
    }

    @Override
    public List<ReservedBikeDTO> getUnReservedBikes(String date1,String date2) {
        List<ReservedBike> reservedBikes = rentDetailRepository.getUnReservedBikes(date1,date2);
        List<ReservedBikeDTO> reservedBikeDTOS = new ArrayList<>();
        for (ReservedBike bike : reservedBikes){
            reservedBikeDTOS.add(new ReservedBikeDTO(bike.getBikeId(),bike.getBikeBrandName(),bike.getBikeName(),bike.getBikeNumber(),bike.getBikePrice(),bike.getBikeType(),bike.getStatus()));
        }
        return reservedBikeDTOS;
    }
}
