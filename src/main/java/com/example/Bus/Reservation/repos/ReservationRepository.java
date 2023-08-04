package com.example.Bus.Reservation.repos;

import com.example.Bus.Reservation.entities.BusSchedule;
import com.example.Bus.Reservation.entities.Customer;
import com.example.Bus.Reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Optional<List<Reservation>> findByCustomer(Customer customer);

    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule,String departureDate );
}
