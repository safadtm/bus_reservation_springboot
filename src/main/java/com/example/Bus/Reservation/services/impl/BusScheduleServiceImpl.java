package com.example.Bus.Reservation.services.impl;

import com.example.Bus.Reservation.entities.Bus;
import com.example.Bus.Reservation.entities.BusRoute;
import com.example.Bus.Reservation.entities.BusSchedule;
import com.example.Bus.Reservation.models.ReservationApiException;
import com.example.Bus.Reservation.repos.BusRepository;
import com.example.Bus.Reservation.repos.BusRouteRepository;
import com.example.Bus.Reservation.repos.BusScheduleRepository;
import com.example.Bus.Reservation.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusScheduleServiceImpl implements BusScheduleService {
    @Autowired
    private BusRepository busRepository;
   @Autowired
   private BusScheduleRepository busScheduleRepository;

   @Autowired
   private BusRouteRepository busRouteRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationApiException {


        Bus bus = busRepository.save(busSchedule.getBus());
        BusRoute busRoute = busRouteRepository.save(busSchedule.getBusRoute());

        busSchedule.setBus(bus);
        busSchedule.setBusRoute(busRoute);


        final Boolean exists=busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(),
                busSchedule.getBusRoute(),
                busSchedule.getDepartureTime());
        if (exists) {
            throw new ReservationApiException(HttpStatus.CONFLICT,"Duplicate Schedule");
        }


        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getScheduleByRoute(String routeName) {
      final BusRoute busRoute= busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"Not found") );

        return busScheduleRepository.findByBusRoute( busRoute).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"Not found") );
    }
}
