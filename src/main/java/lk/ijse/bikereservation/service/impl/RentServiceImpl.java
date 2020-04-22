package lk.ijse.bikereservation.service.impl;

import lk.ijse.bikereservation.dto.CommonRentDTO;
import lk.ijse.bikereservation.dto.PaymentDTO;
import lk.ijse.bikereservation.dto.RentDTO;
import lk.ijse.bikereservation.dto.RentDetailDTO;
import lk.ijse.bikereservation.entity.Bike;
import lk.ijse.bikereservation.entity.Payment;
import lk.ijse.bikereservation.entity.Rent;
import lk.ijse.bikereservation.exception.RecordNotFoundException;
import lk.ijse.bikereservation.mapper.PaymentMapper;
import lk.ijse.bikereservation.mapper.RentDetailMapper;
import lk.ijse.bikereservation.mapper.RentMapper;
import lk.ijse.bikereservation.mapper.impl.PaymentMapperImpl;
import lk.ijse.bikereservation.mapper.impl.RentDetailMapperImpl;
import lk.ijse.bikereservation.mapper.impl.RentMapperImpl;
import lk.ijse.bikereservation.repository.BikeRepository;
import lk.ijse.bikereservation.repository.PaymentRepository;
import lk.ijse.bikereservation.repository.RentDetailRepository;
import lk.ijse.bikereservation.repository.RentRepository;
import lk.ijse.bikereservation.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;
    @Autowired
    RentDetailRepository rentDetailRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    BikeRepository bikeRepository;

    private RentMapper rentMapper = new RentMapperImpl();
    private RentDetailMapper rentDetailMapper = new RentDetailMapperImpl();
    private PaymentMapper paymentMapper = new PaymentMapperImpl();

    @Override
    public CommonRentDTO addRent(CommonRentDTO commonRentDTO) {
        PaymentDTO paymentDTO = new PaymentDTO(
                commonRentDTO.getPaymentId(),commonRentDTO.getCardHoldersName(),commonRentDTO.getBankName(),
                commonRentDTO.getCardNumber(),commonRentDTO.getTotalAmount()
        );
        Payment payment = paymentRepository.save(paymentMapper.convertToPayment(paymentDTO));


        RentDTO rentDTO = new RentDTO(
                commonRentDTO.getRentId(),commonRentDTO.getGuestId(),commonRentDTO.getPaymentId()
        );
        rentDTO.setPaymentId(payment.getPaymentId());
        Rent rent = rentRepository.save(rentMapper.convertToRent(rentDTO));


        for (RentDetailDTO rentDetailDTO : commonRentDTO.getRentDetailDTOS()){
            rentDetailDTO.setRentId(rent.getRentId());
            rentDetailDTO.setStatus("Reserved");
            RentDetailDTO rentDetailDTO1 = new RentDetailDTO(
                    rentDetailDTO.getRentDetailId(),rentDetailDTO.getBikeId(),rentDetailDTO.getRentId(),
                    rentDetailDTO.getRentDate(),rentDetailDTO.getHandOverDate(),
                    rentDetailDTO.getLocation(),rentDetailDTO.getStatus()
            );
            rentDetailRepository.save(rentDetailMapper.convertToRentDetail(rentDetailDTO1));
            Bike bike = bikeRepository.findById(rentDetailDTO1.getBikeId()).orElseThrow(()->
                    new RecordNotFoundException("Bike Not Found"));
            if (bike != null){
                bike.setBikeStatus("Rented");
                bikeRepository.save(bike);
            }
        }
        return commonRentDTO;
    }
}
