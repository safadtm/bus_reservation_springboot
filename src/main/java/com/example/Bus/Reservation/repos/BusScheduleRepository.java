package com.example.Bus.Reservation.repos;

import com.example.Bus.Reservation.entities.Bus;
import com.example.Bus.Reservation.entities.BusRoute;
import com.example.Bus.Reservation.entities.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {

    Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);

    Boolean existsByBusAndBusRouteAndDepartureTime(Bus bus,BusRoute busRoute,String departureTime);
}
