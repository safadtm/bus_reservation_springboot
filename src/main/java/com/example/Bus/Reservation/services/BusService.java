package com.example.Bus.Reservation.services;


import com.example.Bus.Reservation.entities.Bus;

import java.util.List;

public interface BusService {
    Bus addBus(Bus bus);

    List<Bus> getAllBus();

}
