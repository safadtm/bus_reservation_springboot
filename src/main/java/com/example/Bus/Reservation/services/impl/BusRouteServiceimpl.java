package com.example.Bus.Reservation.services.impl;

import com.example.Bus.Reservation.entities.BusRoute;
import com.example.Bus.Reservation.models.ReservationApiException;
import com.example.Bus.Reservation.repos.BusRepository;
import com.example.Bus.Reservation.repos.BusRouteRepository;
import com.example.Bus.Reservation.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceimpl implements BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;
    @Override
    public BusRoute addRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom,cityTo).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }
}
