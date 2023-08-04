package com.example.Bus.Reservation.services.impl;

import com.example.Bus.Reservation.entities.BusSchedule;
import com.example.Bus.Reservation.entities.Customer;
import com.example.Bus.Reservation.entities.Reservation;
import com.example.Bus.Reservation.models.ReservationApiException;
import com.example.Bus.Reservation.repos.BusScheduleRepository;
import com.example.Bus.Reservation.repos.CustomerRepository;
import com.example.Bus.Reservation.repos.ReservationRepository;
import com.example.Bus.Reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        final Customer customer;
        final boolean doesCustomerExist =customerRepository.existsByMobileOrEmail(reservation.getCustomer().getMobile(),reservation.getCustomer().getEmail());

        if (doesCustomerExist){
            customer = customerRepository.findByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail()).orElseThrow();
        }else{
            customer =customerRepository.save(reservation.getCustomer());
        }
        reservation.setCustomer(customer);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationByScheduleAndDepartureDate(Long scheduleId, String departureDate) {
        final BusSchedule schedule=busScheduleRepository.findById(scheduleId).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"Schedule not found"));
        return reservationRepository.findByBusScheduleAndDepartureDate(schedule,departureDate).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"Reservation not found"));
    }

    @Override
    public List<Reservation> getReservationsByMobile(String mobile) {
    final Customer customer=customerRepository.findByMobile(mobile).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No record found"));
    return reservationRepository.findByCustomer(customer).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"Reservation not found"));
    }
}
