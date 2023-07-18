package com.example.Bus.Reservation.services;

import com.example.Bus.Reservation.entities.BusRoute;

import java.util.List;

public interface BusRouteService {

    BusRoute addRoute(BusRoute busRoute);

    List<BusRoute> getAllBusRoutes();

    BusRoute getRouteByRouteName(String routeName);

    BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo);
}
